package com.rixin.wechat.bean.response.component.wxa;

import com.rixin.wechat.bean.entity.component.wxa.WxOpens;
import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 获取公众号关联的小程序接口返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class WxaMpLinkGetResponse extends BaseResponse {
    private WxOpens wxopens;

    public WxOpens getWxopens() {
        return wxopens;
    }

    public void setWxopens(WxOpens wxopens) {
        this.wxopens = wxopens;
    }

    @Override
    public String toString() {
        return "WxaMpLinkGetResponse{"
                + "wxopens=" + wxopens
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
