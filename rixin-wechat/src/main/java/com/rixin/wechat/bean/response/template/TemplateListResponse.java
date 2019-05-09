package com.rixin.wechat.bean.response.template;

import com.rixin.wechat.bean.entity.template.Template;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 模板列表.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TemplateListResponse extends BaseResponse {
    private List<Template> templateList;

    public List<Template> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<Template> templateList) {
        this.templateList = templateList;
    }

    @Override
    public String toString() {
        return "TemplateListResponse{"
                + "templateList=" + templateList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
