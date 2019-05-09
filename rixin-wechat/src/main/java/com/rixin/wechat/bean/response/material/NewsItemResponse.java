package com.rixin.wechat.bean.response.material;

import com.rixin.wechat.bean.entity.message.Article;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 图文素材返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class NewsItemResponse extends BaseResponse {
    private List<Article> newsItem;

    public List<Article> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(List<Article> newsItem) {
        this.newsItem = newsItem;
    }

    @Override
    public String toString() {
        return "GetMaterialNewsResponse{"
                + "newsItem=" + newsItem
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
