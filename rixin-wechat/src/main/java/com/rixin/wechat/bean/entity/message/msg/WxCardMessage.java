package com.rixin.wechat.bean.entity.message.msg;

import com.rixin.wechat.bean.entity.message.MsgType;

/**
 * 卡券信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class WxCardMessage extends Message {
    private WxCard wxcard;

    /**
     * 构造卡券信息.
     */
    public WxCardMessage(String touser, String cardId) {
        super(touser, MsgType.WXCARD.name().toLowerCase());
        this.wxcard = new WxCard();
        this.wxcard.setCardId(cardId);
    }

    public WxCard getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxCard wxcard) {
        this.wxcard = wxcard;
    }

    public static class WxCard {
        private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }
}
