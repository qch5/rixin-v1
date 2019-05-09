package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.ip.IpListResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 获取为新服务器IP接口测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class IpApiTest extends BaseApiTest {
    @Test
    public void testGetIp() {
        IpListResponse result = IpApi.getIpList(TOKEN);
        System.out.println("Get Ip List: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
