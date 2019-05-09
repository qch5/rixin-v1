package com.rixin.wechat.bean.entity.message.massmsg;

import com.rixin.wechat.bean.entity.message.MsgType;

import java.util.HashMap;
import java.util.Map;

/**
 * 群发音乐消息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class MassMusicMessage extends MassMessage {
    private Map<String, String> music;

    /**
     * 构造群发音乐消息.
     */
    public MassMusicMessage(String mediaId) {
        super(MsgType.MUSIC.name().toLowerCase());
        music = new HashMap<>();
        music.put("media_id", mediaId);
    }

    public Map<String, String> getMusic() {
        return music;
    }

    public void setMusic(Map<String, String> music) {
        this.music = music;
    }
}
