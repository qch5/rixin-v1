package com.rixin.wechat.bean.response.sns;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 网页授权access_token.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class SnsTokenResponse extends BaseResponse {
    private String accessToken; //网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    private Integer expiresIn; //access_token接口调用凭证超时时间，单位（秒）
    private String refreshToken; //用户刷新access_token
    private String openid; //用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
    private String scope; //用户授权的作用域，使用逗号（,）分隔

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "SnsTokenResponse{"
                + "accessToken='" + accessToken + '\''
                + ", expiresIn=" + expiresIn
                + ", refreshToken='" + refreshToken + '\''
                + ", openid='" + openid + '\''
                + ", scope='" + scope + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
