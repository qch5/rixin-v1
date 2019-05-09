package com.rixin.wechat.api;

import com.rixin.wechat.Const;
import com.rixin.wechat.bean.response.autoreplay.AutoReplyInfoResponse;
import com.rixin.wechat.utils.Params;
import com.rixin.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 公众号的自动回复规则.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class AutoReplyInfoApi {
    private static final String GET_CURRENT_AUTO_REPLAY_INFO =
            Const.Uri.API_URI + "/cgi-bin/get_current_autoreply_info";

    /**
     * 获取公众号的自动回复规则.包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复.
     */
    public static AutoReplyInfoResponse getCurrent(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_CURRENT_AUTO_REPLAY_INFO, params, AutoReplyInfoResponse.class);
    }
}
