package com.rixin.wechat.bean.entity.message.msg;


import com.rixin.wechat.bean.entity.message.MsgType;

/**
 * 文本消息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TextMessage extends Message {
    private Text text;

    public TextMessage(String touser) {
        super(touser, MsgType.TEXT.name().toLowerCase());
    }


    public TextMessage(String touser, String content) {
        this(touser);
        this.text = new Text();
        this.text.setContent(content);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public static class Text {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
