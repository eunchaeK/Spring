package com.fastcampus.ch4.domain;

public class SearchCondition {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Integer offset = 0;
    private String keyword = "";
    private String option = "";

    public SearchCondition() {}

    public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }

    public Integer getPage() {
        return page;
    }

    public SearchCondition setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public SearchCondition setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public SearchCondition setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public SearchCondition setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getOption() {
        return option;
    }

    public SearchCondition setOption(String option) {
        this.option = option;
        return this;
    }
}
