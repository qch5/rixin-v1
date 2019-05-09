package com.rixin.wechat.bean.entity.material;

/**
 * 新增永久视频素材需特别注意.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class Description {
    private String title;
    private String introduction;

    public Description(String title, String introduction) {
        this.title = title;
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Description{" +
                "title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
