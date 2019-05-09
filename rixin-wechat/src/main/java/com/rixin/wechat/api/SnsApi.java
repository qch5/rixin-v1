package com.rixin.wechat.api;

import com.rixin.wechat.Const;
import com.rixin.wechat.bean.response.BaseResponse;
import com.rixin.wechat.bean.response.sns.SnsTokenResponse;
import com.rixin.wechat.bean.response.user.UserResponse;
import com.rixin.wechat.utils.Params;
import com.rixin.wechat.utils.UrlUtils;
import com.rixin.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 网页授权.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842">WeChat DOC</a>
 */
public class SnsApi {

    /**
     * 获取授权URL。
     * 第一步：用户同意授权，获取code;如果用户同意授权，页面附带code,state跳转至redirect_uri
     *
     * @param appId       公众号的唯一标识
     * @param redirectUri 授权后重定向的回调链接地址
     * @param detail      应用授权作用域:
     *                    false: snsapi_base;不弹出授权页面，直接跳转，只能获取用户openid.
     *                    true: snsapi_userinfo;弹出授权页面，可通过openid拿到昵称、性别、所在地.
     *                    并且，即使在未关注的情况下，只要用户授权，也能获取其信息.
     * @param state       重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     *                    服务方的appid，在申请创建公众号服务成功后，可在公众号服务详情页找到
     * @return 授权URL
     */
    public static String getOath2Url(String appId, String redirectUri, boolean detail, String state) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.Uri.OPEN_URI + "/connect/oauth2/authorize?")
                .append("appid=").append(appId)
                .append("&redirect_uri=").append(UrlUtils.encode(redirectUri))
                .append("&response_type=code")
                .append("&scope=").append(detail ? "snsapi_userinfo" : "snsapi_base")
                .append("&state=").append(state == null ? "" : state);
        sb.append("#wechat_redirect");
        return sb.toString();
    }

    private static final String SNS_OAUTH2_TOKEN = Const.Uri.API_URI + "/sns/oauth2/access_token";

    /**
     * 第二步：通过code换取网页授权access_token.
     *
     * @param appId  公众号的唯一标识
     * @param secret 公众号的appsecret
     * @param code   填写第一步获取的code参数
     */
    public static SnsTokenResponse oauth2AccessToken(String appId, String secret, String code) {
        Map<String, String> params = Params.create("appid", appId).put("secret", secret).put("code", code)
                .put("grant_type", "authorization_code").get();
        return HttpUtil.getJsonBean(SNS_OAUTH2_TOKEN, params, SnsTokenResponse.class);
    }


    private static final String SNS_OAUTH2_REFRESH_TOKEN = Const.Uri.API_URI + "/sns/oauth2/refresh_token";

    /**
     * 第三步：刷新access_token（如果需要）.
     *
     * @param appId        公众号的唯一标识
     * @param refreshToken 填写通过access_token获取到的refresh_token参数
     */
    public static SnsTokenResponse oauth2RefreshToken(String appId, String refreshToken) {
        Map<String, String> params = Params.create("appid", appId).put("refresh_token", refreshToken)
                .put("grant_type", "refresh_token").get();
        return HttpUtil.getJsonBean(SNS_OAUTH2_REFRESH_TOKEN, params, SnsTokenResponse.class);
    }

    private static final String SNS_USER_INFO = Const.Uri.API_URI + "/sns/getUserInfo";

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo).
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid      用户的唯一标识
     * @param lang        国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     */
    public static UserResponse getUserInfo(String accessToken, String openid, String lang) {
        Map<String, String> params = Params.create("access_token", accessToken).put("openid", openid)
                .put("lang", lang).get();
        return HttpUtil.getJsonBean(SNS_USER_INFO, params, UserResponse.class);
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo).
     */
    public static UserResponse getUserInfo(String accessToken, String openid) {
        return getUserInfo(accessToken, openid, "zh_CN");
    }


    private static final String SNS_AUTH = Const.Uri.API_URI + "/sns/auth";

    /**
     * 检验授权凭证（access_token）是否有效.
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid      用户的唯一标识
     */
    public static BaseResponse snsAuth(String accessToken, String openid) {
        Map<String, String> params = Params.create("access_token", accessToken).put("openid", openid).get();
        return HttpUtil.getJsonBean(SNS_AUTH, params, BaseResponse.class);
    }
}
