package com.rixin.wechat.utils.client;

import org.junit.Assert;
import org.junit.Test;

/**
 * Http工具类测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class HttpUtilTest {
    @Test
    public void testGet() {
        String response = HttpUtil.get("https://mp.weixin.qq.com/wiki", null);
        Assert.assertNotNull(response);
    }
}
