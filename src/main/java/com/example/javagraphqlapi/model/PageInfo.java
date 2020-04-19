package com.example.javagraphqlapi.model;

/**
 * @author : RXK
 * Date : 2020/4/19 9:24
 * Code Less Think More
 * Desc:
 */
public class PageInfo {

    private Integer totalCount;

    private boolean nextPage;

    private Integer pageSize;

    private Integer pageNum;

    public PageInfo() {
    }

    public PageInfo(Integer totalCount, Integer pageSize, Integer pageNum,boolean nextPage) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.nextPage = nextPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public boolean getNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
