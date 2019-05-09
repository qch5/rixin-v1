package com.rixin.base.page;

/**
 * User: dairan
 * Date: 2015-12-04 20:34
 */
public class PageBean {

    private PageMeta page = new PageMeta();

    /**
     * @param pageNum   查询第几页
     * @param pageMax   每页显示最大条数
     */
    public void setPageInfo(Integer pageNum, Integer pageMax) {
        if(null == pageNum) {
            pageNum = 1;
        }
        page.setPage(pageNum);
        if(null != pageMax ){
            page.setPageMax(pageMax);
        }

    }

    public PageMeta getPage() {
        return page;
    }

    public void setPage(PageMeta page) {
        this.page = page;
    }
}
