package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer page = 1;
    private Integer pageSize = 10;
//    private Integer offset = 0;
    private String keyword = "";
    private String option = "";

    public SearchCondition() {}

    public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }

    public String getQueryString(Integer page){
        // ?page=1&pageSize=10&option=T&keyword=title
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize",pageSize)
                .queryParam("option", option)
                .queryParam("keyword", keyword)
                .build().toString();
    }

    public String getQueryString(){
        // ?page=1&pageSize=10&option=T&keyword=title
        return getQueryString(page);
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

    public Integer getOffset() {    // 어디서부터 DB 데이터 가져올지(mapper에서 사용)
        return (page-1) * pageSize;
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

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
