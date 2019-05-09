package com.rixin.wechat.api.component.wxa;

import com.rixin.wechat.Const;
import com.rixin.wechat.bean.response.BaseResponse;
import com.rixin.wechat.bean.response.component.wxa.GetWxaSearchStatusResponse;
import com.rixin.wechat.utils.Params;
import com.rixin.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 小程序基础信息设置.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class SettingApi {
    private static final String CHANGE_WXA_SEARCH_STATUS = Const.Uri.API_URI + "/wxa/changewxasearchstatus";

    /**
     * 设置小程序隐私设置（是否可被搜索）.
     *
     * @param accessToken 请求token
     * @param status      1表示不可搜索，0表示可搜索
     * @return {@link BaseResponse}
     */
    public BaseResponse changeWxaSearchStatus(String accessToken, int status) {
        String data = String.format("{\"status\":%s}", status);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(CHANGE_WXA_SEARCH_STATUS, params, data, BaseResponse.class);
    }


    private static final String GET_WXA_SEARCH_STATUS = Const.Uri.API_URI + "/wxa/changewxasearchstatus";

    /**
     * 查询小程序当前隐私设置（是否可被搜索）.
     *
     * @param accessToken 请求token
     * @return {@link BaseResponse}
     */
    public GetWxaSearchStatusResponse getWxaSearchStatus(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(CHANGE_WXA_SEARCH_STATUS, params, GetWxaSearchStatusResponse.class);
    }
}
