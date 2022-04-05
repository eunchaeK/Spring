package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
//    private int page;          // 현재 페이지
//    private int pageSize;      // 한 페이지의 크기
//    private String option;
//    private String keyword;

    private SearchCondition sc;
    private int totalCnt;      // 총 게시물 갯수
    private int navSize=10;    // 페이지 내비게이션의 크기
    private int totalPage;     // 전체 페이지의 갯수
    private int beginPage;     // 내이게이션의 첫번째 페이지
    private int endPage;       // 내비게이션의 마지막 페이지
    private boolean showPrev;  // 이전 페이지로 이동하는 링크를 보여줄 것인지 여부
    private boolean showNext;  // 다음 페이지로 이동하는 링크를 보여줄 것인지 여부

    public PageHandler(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

    public void doPaging(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;

        totalPage = (int)Math.ceil(totalCnt/ (double)sc.getPageSize());     // 정수/정수 -> 정수
        beginPage = (sc.getPage()-1) / navSize * navSize + 1;
        endPage = Math.min(beginPage + navSize -1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public PageHandler setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
        return this;
    }


    public int getNavSize() {
        return navSize;
    }

    public PageHandler setNavSize(int navSize) {
        this.navSize = navSize;
        return this;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public PageHandler setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }


    public int getBeginPage() {
        return beginPage;
    }

    public PageHandler setBeginPage(int beginPage) {
        this.beginPage = beginPage;
        return this;
    }

    public int getEndPage() {
        return endPage;
    }

    public PageHandler setEndPage(int endPage) {
        this.endPage = endPage;
        return this;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public PageHandler setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
        return this;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public PageHandler setShowNext(boolean showNext) {
        this.showNext = showNext;
        return this;
    }

    public SearchCondition getSc() {
        return sc;
    }

    public PageHandler setSc(SearchCondition sc) {
        this.sc = sc;
        return this;
    }

    void print(){
        System.out.println("page = " + sc.getPage());
        System.out.print(showPrev ? "[PREV] " : "");
        for (int i = beginPage; i <= endPage ; i++) {
            System.out.print(i + " ");
        }
        System.out.print(showNext ? "[NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", totalCnt=" + totalCnt +
                ", navSize=" + navSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
