package com.rixin.wechat.bean.response.component;

import com.rixin.wechat.bean.entity.component.AuthorizerInfo;
import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 授权方总的的账户信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class GetAuthorizerInfoResponse extends BaseResponse {
    private AuthorizerInfo authorizerInfo;
    private String qrcodeUrl; //二维码图片链接
    private QueryAuthResponse authorizationInfo;

    public AuthorizerInfo getAuthorizerInfo() {
        return authorizerInfo;
    }

    public void setAuthorizerInfo(AuthorizerInfo authorizerInfo) {
        this.authorizerInfo = authorizerInfo;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public QueryAuthResponse getAuthorizationInfo() {
        return authorizationInfo;
    }

    public void setAuthorizationInfo(QueryAuthResponse authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }

    @Override
    public String toString() {
        return "GetAuthorizerInfoResponse{"
                + "authorizerInfo=" + authorizerInfo
                + ", qrcodeUrl='" + qrcodeUrl + '\''
                + ", authorizationInfo=" + authorizationInfo
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
