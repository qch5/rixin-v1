package com.rixin.wechat.api;

import com.rixin.wechat.utils.client.HttpUtil;
import com.rixin.wechat.Const;
import com.rixin.wechat.bean.response.ticket.TicketResponse;
import com.rixin.wechat.utils.Params;

import java.util.Map;

/**
 * JSAPI ticket.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TicketApi {
    private static final String TICKET_GET = Const.Uri.API_URI + "/cgi-bin/ticket/getticket";

    /**
     * 获取 jsapi_ticket.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     */
    public static TicketResponse getTicket(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken)
                .put("type", "jsapi").get();
        return HttpUtil.getJsonBean(TICKET_GET, params, TicketResponse.class);
    }
}
