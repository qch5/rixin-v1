package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.token.TokenResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * token相关API测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TokenApiTest extends BaseApiTest {
    @Test
    public void testGetToken() {
        TokenResponse result = TokenApi.token(APP_ID, APP_SECRET);
        System.out.println("Get access token: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
