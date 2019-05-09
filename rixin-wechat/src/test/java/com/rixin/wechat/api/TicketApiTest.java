package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.ticket.TicketResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * js api ticket接口测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TicketApiTest extends BaseApiTest {
    @Test
    public void testGetToken() {
        TicketResponse result = TicketApi.getTicket(TOKEN);
        System.out.println("Get access token: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
