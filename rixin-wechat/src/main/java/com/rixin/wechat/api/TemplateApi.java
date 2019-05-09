package com.rixin.wechat.api;

import com.rixin.wechat.Const;
import com.rixin.wechat.bean.entity.template.TemplateMessage;
import com.rixin.wechat.bean.response.BaseResponse;
import com.rixin.wechat.bean.response.template.IndustryResponse;
import com.rixin.wechat.bean.response.template.SendTemplateMsgResponse;
import com.rixin.wechat.bean.response.template.TemplateListResponse;
import com.rixin.wechat.bean.response.template.TemplateResponse;
import com.rixin.wechat.utils.Params;
import com.rixin.wechat.utils.client.HttpUtil;
import com.rixin.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 模板相关接口.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TemplateApi {

    private static final String API_SET_INDUSTRY = Const.Uri.API_URI + "/cgi-bin/template/api_set_industry";

    /**
     * 设置所属行业,每月可修改行业1次.
     */
    public static BaseResponse setIndustry(String accessToken, String id1, String id2) {
        Map<String, String> map = Params.create("industry_id1", id1).put("industry_id2", id2).get();
        String data = SerializeUtil.beanToJson(map);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(API_SET_INDUSTRY, params, data, BaseResponse.class);
    }


    private static final String GET_INDUSTRY = Const.Uri.API_URI + "/cgi-bin/template/get_industry";

    /**
     * 获取帐号设置的行业信息.
     */
    public static IndustryResponse getIndustry(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_INDUSTRY, params, IndustryResponse.class);
    }


    private static final String GET_ALL_PRIVATE_TEMPLATE =
            Const.Uri.API_URI + "/cgi-bin/template/get_all_private_template";

    /**
     * 获取已添加至帐号下所有模板列表.
     */
    public static TemplateListResponse getAllPrivateTemplate(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_ALL_PRIVATE_TEMPLATE, params, TemplateListResponse.class);
    }


    private static final String API_ADD_TEMPLATE = Const.Uri.API_URI + "/cgi-bin/template/api_add_template";

    /**
     * 从行业模板库选择模板到帐号后台.
     *
     * @param templateIdShort 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     */
    public static TemplateResponse addTemplate(String accessToken, String templateIdShort) {
        Map<String, String> map = Params.create("template_id_short", templateIdShort).get();
        String data = SerializeUtil.beanToJson(map);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(API_ADD_TEMPLATE, params, data, TemplateResponse.class);
    }


    private static final String API_DELETE_TEMPLATE = Const.Uri.API_URI + "/cgi-bin/template/del_private_template";

    /**
     * 删除模板.
     *
     * @param templateId 公众帐号下模板消息ID
     */
    public static BaseResponse delPrivateTemplate(String accessToken, String templateId) {
        Map<String, String> map = Params.create("template_id", templateId).get();
        String data = SerializeUtil.beanToJson(map);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(API_DELETE_TEMPLATE, params, data, TemplateResponse.class);
    }


    private static final String MSG_TEMPLATE_SEND = Const.Uri.API_URI + "/cgi-bin/message/template/send";

    /**
     * 模板消息发送.
     */
    public static SendTemplateMsgResponse sendTemplateMessage(String accessToken, TemplateMessage templateMessage) {
        String data = SerializeUtil.beanToJson(templateMessage);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MSG_TEMPLATE_SEND, params, data, SendTemplateMsgResponse.class);
    }
}
