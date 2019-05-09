package com.rixin.wechat.bean.response.component.wxa.template;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 组合模板并添加至帐号下的个人模板库接口返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class LibraryAddResponse extends BaseResponse {
    private String templateId; // 添加至帐号下的模板id，发送小程序模板消息时所需

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "LibraryAddResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", templateId='" + templateId + '\''
                + '}';
    }
}
