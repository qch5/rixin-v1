package com.rixin.wechat.api.component.wxa;

import com.rixin.wechat.Const;
import com.rixin.wechat.bean.response.component.wxa.GetCodeTemplateListResponse;
import com.rixin.wechat.bean.response.component.wxa.GetDraftCodeTemplateListResponse;
import com.rixin.wechat.utils.Params;
import com.rixin.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 小程序代码模版库管理. <br>
 * 第三方平台可以通过接口，可便捷管理模版库，添加或删除小程序代码模版。
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class CodeTemplateApi {
    private static final String GET_TEMPLATE_DRAFT_LIST = Const.Uri.API_URI + "/wxa/gettemplatedraftlist";

    /**
     * 获取草稿箱内的所有临时代码草稿. <br>
     *
     * @param componentAccessToken 请使用第三方平台自己的component_access_token
     */
    public static GetDraftCodeTemplateListResponse getTemplateDraftList(String componentAccessToken) {
        Map<String, String> params = Params.create("access_token", componentAccessToken).get();
        return HttpUtil.getJsonBean(GET_TEMPLATE_DRAFT_LIST, params, GetDraftCodeTemplateListResponse.class);
    }

    private static final String GET_TEMPLATE_LIST = Const.Uri.API_URI + "/wxa/gettemplatelist";

    /**
     * 获取代码模版库中的所有小程序代码模版. <br>
     *
     * @param componentAccessToken 请使用第三方平台自己的component_access_token
     */
    public static GetCodeTemplateListResponse getTemplateList(String componentAccessToken) {
        Map<String, String> params = Params.create("access_token", componentAccessToken).get();
        return HttpUtil.getJsonBean(GET_TEMPLATE_LIST, params, GetCodeTemplateListResponse.class);
    }

    private static final String ADD_TO_TEMPLATE = Const.Uri.API_URI + "/wxa/addtotemplate";

    /**
     * 将草稿箱的草稿选为小程序代码模版. <br>
     *
     * @param componentAccessToken 请使用第三方平台自己的component_access_token
     * @param draftId              草稿id
     */
    public static GetCodeTemplateListResponse getTemplateList(String componentAccessToken, String draftId) {
        String data = String.format("{\"draft_id\":%s}", draftId);
        Map<String, String> params = Params.create("access_token", componentAccessToken).get();
        return HttpUtil.postJsonBean(ADD_TO_TEMPLATE, params, data, GetCodeTemplateListResponse.class);
    }
}
