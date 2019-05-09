package com.rixin.wx.common.interceptor;

import com.google.common.collect.Lists;
import com.rixin.data.domain.WxAccessToken;
import com.rixin.data.domain.WxUserInfo;
import com.rixin.data.service.WxAccessTokenService;
import com.rixin.data.service.WxUserInfoService;
import com.rixin.wechat.api.SnsApi;
import com.rixin.wechat.api.TokenApi;
import com.rixin.wechat.api.UserApi;
import com.rixin.wechat.bean.response.sns.SnsTokenResponse;
import com.rixin.wechat.bean.response.token.TokenResponse;
import com.rixin.wechat.bean.response.user.UserResponse;
import com.rixin.wx.common.config.Constants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: dairan
 * Date: 2019-04-21 16:53
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(com.rixin.base.interceptor.LoginInterceptor.class);
    private final static String STATE = "login";

    @Resource
    private WxUserInfoService wxUserInfoService;
    @Resource
    private WxAccessTokenService wxAccessTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.error("拦截地址：{}", request.getRequestURL());

        HttpSession session = request.getSession();
        UserResponse userInfo = (UserResponse) session.getAttribute("userInfo");
        if(userInfo != null) {
            return true;
        }

        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String openId = "";
        if(StringUtils.isNotBlank(code) && StringUtils.isNotBlank(state) && state.equals(STATE)) {
            SnsTokenResponse snsToken = SnsApi.oauth2AccessToken(Constants.APP_ID, Constants.APP_SECRET, code);
            openId = snsToken.getOpenid();
        }

        if(StringUtils.isNotBlank(openId)) {
            WxUserInfo wxUserInfo = wxUserInfoService.selectByOpenId(openId);
            if(wxUserInfo != null) {
                userInfo = this.buildUserResponse(wxUserInfo);
            } else {
                WxAccessToken wxAccessToken = wxAccessTokenService.selectAccessToken(Constants.APP_ID, Constants.APP_SECRET);
                if(wxAccessToken == null) {
                    TokenResponse token = TokenApi.token(Constants.APP_ID, Constants.APP_SECRET);
                    wxAccessToken = new WxAccessToken();
                    wxAccessToken.setAppId(Constants.APP_ID);
                    wxAccessToken.setAppSecret(Constants.APP_SECRET);
                    wxAccessToken.setAccess_token(token.getAccessToken());
                    wxAccessToken.setExpires_in(token.getExpiresIn());
                    wxAccessToken.setCreateTime(new Date());
                    wxAccessTokenService.insertAccessToken(wxAccessToken);
                }
                userInfo = UserApi.getUserInfo(wxAccessToken.getAccess_token(), openId);
                if(userInfo != null && userInfo.isSuccess()) {
                    wxUserInfo = this.buildWxUserInfo(userInfo);
                    wxUserInfoService.insert(wxUserInfo);
                }
            }
            if(userInfo != null) {
                session.setMaxInactiveInterval(7200);
                session.setAttribute("userInfo", userInfo);
                return true;
            }
        }

        String url = request.getRequestURL().toString();
        String redirect = SnsApi.getOath2Url(Constants.APP_ID, url, true, STATE);
        response.sendRedirect(redirect);
        return false;
    }

    private UserResponse buildUserResponse(WxUserInfo wxUserInfo) {
        UserResponse userInfo = new UserResponse();
        userInfo.setOpenid(wxUserInfo.getOpenid());
        userInfo.setUnionid(wxUserInfo.getUnionid());
        userInfo.setNickname(wxUserInfo.getNickname());
        userInfo.setSex(wxUserInfo.getSex());
        userInfo.setHeadimgurl(wxUserInfo.getHeadimgurl());
        userInfo.setCountry(wxUserInfo.getCountry());
        userInfo.setProvince(wxUserInfo.getProvince());
        userInfo.setCity(wxUserInfo.getCity());
        userInfo.setLanguage(wxUserInfo.getLanguage());
        userInfo.setGroupid(wxUserInfo.getGroupid());
        String tagIdList = wxUserInfo.getTagid_list();
        if(StringUtils.isNotBlank(tagIdList)) {
            userInfo.setTagidList(Lists.newArrayList(tagIdList.split(",")));
        }
        userInfo.setRemark(wxUserInfo.getRemark());
        userInfo.setSubscribe(wxUserInfo.getSubscribe());
        Date subscribeTime = wxUserInfo.getSubscribe_time();
        if(subscribeTime != null) {
            String second = String.valueOf(subscribeTime.getTime() / 1000);
            userInfo.setSubscribeTime(Integer.parseInt(second));
        }
        return userInfo;
    }

    private WxUserInfo buildWxUserInfo(UserResponse userInfo) {
        WxUserInfo wxUserInfo = new WxUserInfo();
        wxUserInfo.setOpenid(userInfo.getOpenid());
        wxUserInfo.setUnionid(userInfo.getUnionid());
        wxUserInfo.setNickname(userInfo.getNickname());
        wxUserInfo.setSex(userInfo.getSex());
        wxUserInfo.setHeadimgurl(userInfo.getHeadimgurl());
        wxUserInfo.setCountry(userInfo.getCountry());
        wxUserInfo.setProvince(userInfo.getProvince());
        wxUserInfo.setCity(userInfo.getCity());
        wxUserInfo.setLanguage(userInfo.getLanguage());
        wxUserInfo.setGroupid(userInfo.getGroupid());
        List<String> tagIdList = userInfo.getTagidList();
        if(CollectionUtils.isNotEmpty(tagIdList)) {
            wxUserInfo.setTagid_list(tagIdList.stream().collect(Collectors.joining(",")));
        }
        wxUserInfo.setRemark(userInfo.getRemark());
        wxUserInfo.setSubscribe(userInfo.getSubscribe());
        Integer subscribeTime = userInfo.getSubscribeTime();
        if(subscribeTime != null) {
            wxUserInfo.setSubscribe_time(new Date(subscribeTime * 1000L));
        }
        return wxUserInfo;
    }
}
