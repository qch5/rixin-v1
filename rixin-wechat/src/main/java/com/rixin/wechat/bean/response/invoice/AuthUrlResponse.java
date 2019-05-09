package com.rixin.wechat.bean.response.invoice;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 获取授权页链接接口返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class AuthUrlResponse extends BaseResponse {
    private String appid; // 授权链接
    private String authUrl; // source为wxa时才有

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    @Override
    public String toString() {
        return "AuthUrlResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", appid='" + appid + '\''
                + ", authUrl='" + authUrl + '\''
                + '}';
    }
}
