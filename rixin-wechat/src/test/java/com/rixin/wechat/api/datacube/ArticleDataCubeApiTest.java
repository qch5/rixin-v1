package com.rixin.wechat.api.datacube;

import com.rixin.wechat.api.BaseApiTest;
import com.rixin.wechat.bean.response.datacube.ArticleDataCubeResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 图文分析数据接口测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class ArticleDataCubeApiTest extends BaseApiTest {
    private static final String DATE = "018-01-01";
    private static final String DATE_3_AFTER = "018-01-03";
    private static final String DATE_7_AFTER = "018-01-07";

    @Test
    public void testGetArticleSummary() {
        ArticleDataCubeResponse result = ArticleDataCubeApi.getArticleSummary(TOKEN, DATE);
        System.out.println("Get article summary: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGetArticleTotal() {
        ArticleDataCubeResponse result = ArticleDataCubeApi.getArticleTotal(TOKEN, DATE);
        System.out.println("Get article total: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testUserRead() {
        ArticleDataCubeResponse result = ArticleDataCubeApi.getUserRead(TOKEN, DATE, DATE_3_AFTER);
        System.out.println("Get user read: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGetUserReadHour() {
        ArticleDataCubeResponse result = ArticleDataCubeApi.getUserReadHour(TOKEN, DATE);
        System.out.println("Get user read hour: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGetUserShare() {
        ArticleDataCubeResponse result = ArticleDataCubeApi.getUserShare(TOKEN, DATE, DATE_7_AFTER);
        System.out.println("Get user share: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGetUserShareHour() {
        ArticleDataCubeResponse result = ArticleDataCubeApi.getUserShareHour(TOKEN, DATE);
        System.out.println("Get user share hour: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
