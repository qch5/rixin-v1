package com.rixin.wechat.bean.entity.message.massmsg;

import com.rixin.wechat.bean.entity.message.MsgType;

import java.util.HashMap;
import java.util.Map;

/**
 * 群发卡券信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class MassWxCardMessage extends MassMessage {
    private Map<String, String> wxcard;

    /**
     * 根据卡券ID构造群发卡券信息对象.
     */
    public MassWxCardMessage(String cardId) {
        super(MsgType.WXCARD.name().toLowerCase());
        wxcard = new HashMap<>();
        wxcard.put("card_id", cardId);
    }

    public Map<String, String> getWxcard() {
        return wxcard;
    }

    public void setWxcard(Map<String, String> wxcard) {
        this.wxcard = wxcard;
    }
}
