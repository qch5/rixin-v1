package com.rixin.wechat.bean.response.template;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 模板消息发送结果.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class SendTemplateMsgResponse extends BaseResponse {
    private Long msgid;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    @Override
    public String toString() {
        return "SendTemplateMsgResponse{"
                + "msgid=" + msgid
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
