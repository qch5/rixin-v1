package com.rixin.wechat.bean.entity.message.msg;

import com.rixin.wechat.bean.entity.message.MsgType;

/**
 * 图片消息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class ImageMessage extends Message {
    private Image image;

    /**
     * 根据图片ID构造图片消息对象.
     */
    public ImageMessage(String touser, String mediaId) {
        super(touser, MsgType.IMAGE.name().toLowerCase());
        this.image = new Image();
        this.image.setMediaId(mediaId);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static class Image {
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
