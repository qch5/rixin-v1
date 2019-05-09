package com.rixin.wechat.bean.response.media;


import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 临时视频素材下载地址.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class VideoUrlResponse extends BaseResponse {
    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "VideoUrlResponse{"
                + "videoUrl='" + videoUrl + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
