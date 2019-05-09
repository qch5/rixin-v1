package com.rixin.wechat.api;

import com.rixin.wechat.bean.response.ip.IpListResponse;
import com.rixin.wechat.utils.client.HttpUtil;
import com.rixin.wechat.Const;
import com.rixin.wechat.utils.Params;

import java.util.Map;

/**
 * 微信服务器IP API接口.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class IpApi {
    private static final String GET_CALL_BACK_IP = Const.Uri.API_URI + "/cgi-bin/getcallbackip";

    /**
     * 获取微信服务器IP地址.
     */
    public static IpListResponse getIpList(String token) {
        Map<String, String> params = Params.create("access_token", token).get();
        return HttpUtil.getJsonBean(GET_CALL_BACK_IP, params, IpListResponse.class);
    }
}
