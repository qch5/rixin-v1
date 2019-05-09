package com.rixin.wechat.bean.response.material;


import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 素材总数.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class MaterialCountResponse extends BaseResponse {
    private Integer voiceCount;
    private Integer videoCount;
    private Integer imageCount;
    private Integer newsCount;

    public Integer getVoiceCount() {
        return voiceCount;
    }

    public void setVoiceCount(Integer voiceCount) {
        this.voiceCount = voiceCount;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public Integer getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(Integer newsCount) {
        this.newsCount = newsCount;
    }

    @Override
    public String toString() {
        return "MaterialCountResponse{"
                + "voiceCount=" + voiceCount
                + ", videoCount=" + videoCount
                + ", imageCount=" + imageCount
                + ", newsCount=" + newsCount
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
