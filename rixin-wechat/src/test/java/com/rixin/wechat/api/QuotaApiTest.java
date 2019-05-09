package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.BaseResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 接口调用频次API测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class QuotaApiTest extends BaseApiTest {

    @Test
    public void testClearQuota() {
        BaseResponse result = QuotaApi.clearQuota(TOKEN, APP_ID);
        System.out.println("Clear Quota: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
