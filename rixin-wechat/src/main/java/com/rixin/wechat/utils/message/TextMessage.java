package com.rixin.wechat.utils.message;

/**
 * User: dairan
 * Date: 2019-04-15 10:38
 */
public class TextMessage extends BaseMessage {
    private String Content;
    private String MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
