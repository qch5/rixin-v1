package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.BaseResponse;
import com.rixin.wechat.bean.response.message.MessageSendSpeedResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 群发接口测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class MassMsgApiTest extends BaseApiTest {
    @Test
    public void testMassSpeed() {
        BaseResponse result1 = MassMsgApi.setMassSpeed(TOKEN, 1);
        System.out.println("Set mass speed: " + result1);
        Assert.assertEquals(true, result1.isSuccess());

        MessageSendSpeedResponse result2 = MassMsgApi.getMassSpeed(TOKEN);
        System.out.println("Get mass speed:" + result2);
        Assert.assertEquals(true, result2.isSuccess());
    }

}
