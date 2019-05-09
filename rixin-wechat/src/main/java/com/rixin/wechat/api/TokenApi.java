package com.rixin.wechat.api;

import com.rixin.base.utils.BeanUtils;
import com.rixin.data.domain.WxAccessToken;
import com.rixin.data.service.WxAccessTokenService;
import com.rixin.wechat.bean.response.token.TokenResponse;
import com.rixin.wechat.utils.client.HttpUtil;
import com.rixin.wechat.Const;
import com.rixin.wechat.utils.Params;

import java.util.Date;
import java.util.Map;

/**
 * 微信Token相关API接口.
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TokenApi {
    private static final String ACCESS_TOKEN_URL = Const.Uri.API_URI + "/cgi-bin/token";

    /**
     * 获取access_token.
     * @param appId  第三方用户唯一凭证
     * @param secret 第三方用户唯一凭证密钥，即appsecret
     */
    public static TokenResponse token(String appId, String secret) {
        Map<String, String> params = Params.create("grant_type", "client_credential").put("appid", appId).put("secret", secret).get();
        return HttpUtil.getJsonBean(ACCESS_TOKEN_URL, params, TokenResponse.class);
    }

    /**
     * 获取access_token
     */
    public static String getAccessToken(String appId, String appSecret) {
        WxAccessTokenService wxAccessTokenService = (WxAccessTokenService) BeanUtils.getBean("wxAccessTokenService");
        WxAccessToken wxAccessToken = wxAccessTokenService.selectAccessToken(appId, appSecret);
        if(wxAccessToken != null) {
            return wxAccessToken.getAccess_token();
        }
        Map<String, String> params = Params.create("grant_type", "client_credential").put("appid", appId).put("secret", appSecret).get();
        TokenResponse tokenResponse = HttpUtil.getJsonBean(ACCESS_TOKEN_URL, params, TokenResponse.class);
        wxAccessToken = new WxAccessToken();
        wxAccessToken.setAccess_token(tokenResponse.getAccessToken());
        wxAccessToken.setExpires_in(tokenResponse.getExpiresIn());
        wxAccessToken.setAppId(appId);
        wxAccessToken.setAppSecret(appSecret);
        wxAccessToken.setCreateTime(new Date());
        wxAccessTokenService.insert(wxAccessToken);
        return tokenResponse.getAccessToken();
    }
}
