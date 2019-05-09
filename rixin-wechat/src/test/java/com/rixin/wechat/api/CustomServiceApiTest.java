package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.BaseResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 客服接口测试.
 * 测试号无法测试新客服接口,Pass.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class CustomServiceApiTest extends BaseApiTest {
    @Test
    public void testGetCurrentSelfMenuInfo() {
        String account = "test@" + ACCOUNT_ID;
        BaseResponse result = CustomServiceApi.addAccount(TOKEN, account, "nick");
        System.out.println("Add custom account: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
