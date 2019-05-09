package com.rixin.wechat.bean.response.component;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 开放平台接口返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class OpenResponse extends BaseResponse {
    private String open_appid; //开放平台帐号的appid

    public String getOpen_appid() {
        return open_appid;
    }

    public void setOpen_appid(String open_appid) {
        this.open_appid = open_appid;
    }

    @Override
    public String toString() {
        return "OpenResponse{"
                + "open_appid='" + open_appid + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
