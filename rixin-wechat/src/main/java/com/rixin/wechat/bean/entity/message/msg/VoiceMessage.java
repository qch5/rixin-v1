package com.rixin.wechat.bean.entity.message.msg;

import com.rixin.wechat.bean.entity.message.MsgType;

/**
 * 语音消息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class VoiceMessage extends Message {
    private Voice voice;

    /**
     * 构造语音消息.
     */
    public VoiceMessage(String touser, String mediaId) {
        super(touser, MsgType.VOICE.name().toLowerCase());
        this.voice = new Voice();
        this.voice.setMediaId(mediaId);
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public static class Voice {
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
