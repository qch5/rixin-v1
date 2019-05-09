package com.rixin.wechat.bean.entity.user;

import java.util.List;

/**
 * OpenId列表.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class OpenIdList {
    private List<String> openid; //OPENID的列表

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "OpenIdList{" +
                "openid=" + openid +
                '}';
    }
}
