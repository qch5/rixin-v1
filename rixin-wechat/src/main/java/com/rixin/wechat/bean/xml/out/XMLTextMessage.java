package com.rixin.wechat.bean.xml.out;

import com.rixin.wechat.bean.entity.message.MsgType;

public class XMLTextMessage extends XmlMessage {
    private String content;

    public XMLTextMessage(String toUserName, String fromUserName, String content) {
        super(toUserName, fromUserName, MsgType.TEXT.name().toLowerCase());
        this.content = content;
    }

    @Override
    public String subXml() {
        return "<Content><![CDATA[" + content + "]]></Content>";
    }
}
