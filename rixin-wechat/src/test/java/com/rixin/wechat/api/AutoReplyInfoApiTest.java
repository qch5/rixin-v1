package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.autoreplay.AutoReplyInfoResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 自动回复接口测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class AutoReplyInfoApiTest extends BaseApiTest {
    @Test
    public void testGetToken() {
        AutoReplyInfoResponse result = AutoReplyInfoApi.getCurrent(TOKEN);
        System.out.println("Get auto reply detail: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
