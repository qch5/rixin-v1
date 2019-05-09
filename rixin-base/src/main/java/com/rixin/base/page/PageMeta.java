package com.rixin.base.page;


/**
 * 分页基类
 * User: dairan
 * Date: 2015-12-04 19:32
 */
public class PageMeta {
    public static final int DEFAULT_PAGE_MAX = 15;

    private int page;			    // 当前第几页
    private int pageRow;		    // 当前页条数
    private int pageMax;		    // 每页查询条数
    private int totalPage;		    // 总计分页数
    private int totalRow;		    // 总计记录数

    private Integer from;           // 从第几行开始查询
    private Integer limit;          // 查询行数

    private PageFormat formater;
    
    /* 2017年6月20日 11:35:19 添加开始  */
    private int prevPage; // 上一页
    private int nextPage;  // 下一页

    public PageMeta() {
        page = 0;
        pageRow = 0;
        pageMax = DEFAULT_PAGE_MAX;
        totalPage = 0;
        totalRow = 0;
        formater = DefaultPageFormat.getInstance();
    }

    public PageMeta(int total, int pageMax){
        this(total, pageMax, 1);
    }

    public PageMeta(int total, int pageMax, int page){
        this.page = page;
        this.pageMax = pageMax;
        formater = DefaultPageFormat.getInstance();
        adjustByTotalRow(total);
        this.prevPage = page == 1? 1 : page == totalPage? 1:page - 1;
        this.nextPage = totalPage == 1? 1 : page == totalPage? totalPage:page + 1;
    }

    public void adjustByTotalRow(int total){
        totalRow = total;
        if(totalRow < 1){
            page = 1;
            pageRow = 0;
            totalPage = 0;
            totalRow = 0;
        } else {
            totalPage = (totalRow / pageMax) + ((totalRow % pageMax) == 0 ? 0 : 1);
            if(page > totalPage){
                page = totalPage;
            } else if(page < 1){
                page = 1;
            }
            pageRow = totalRow - (page - 1) * pageMax;
            if (pageRow > pageMax){
                pageRow = pageMax;
            }
        }
        from = (page - 1) * pageMax;
        limit = pageRow;
    }

    public String getTag(){
        return formater.format(this);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageRow() {
        return pageRow;
    }

    public void setPageRow(int pageRow) {
        this.pageRow = pageRow;
    }

    public int getPageMax() {
        return pageMax;
    }

    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
    
	/* 2017年6月20日 11:36:04 添加完成  */

}
