package com.rixin.wechat.bean.entity.message.massmsg;

import com.rixin.wechat.bean.entity.message.MsgType;

import java.util.HashMap;
import java.util.Map;

/**
 * 群发语音/音频消息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class MassVoiceMessage extends MassMessage {
    private Map<String, String> voice;

    /**
     * 构造群发语音/音频消息对象.
     */
    public MassVoiceMessage(String mediaId) {
        super(MsgType.VOICE.name().toLowerCase());
        voice = new HashMap<>();
        voice.put("media_id", mediaId);
    }

    public Map<String, String> getVoice() {
        return voice;
    }

    public void setVoice(Map<String, String> voice) {
        this.voice = voice;
    }
}
