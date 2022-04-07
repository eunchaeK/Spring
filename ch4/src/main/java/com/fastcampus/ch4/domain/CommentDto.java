package com.fastcampus.ch4.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Objects;

public class CommentDto {
    private Integer cno;
    private Integer bno;
    private Integer pcno;
    private String comment;
    private String commenter;
    private Date reg_date;
    private Date up_date;

    public CommentDto() {
    }

    public CommentDto(Integer bno, Integer pcno, String comment, String commenter) {
        this.bno = bno;
        this.pcno = pcno;
        this.comment = comment;
        this.commenter = commenter;
    }

    public int getCno() {
        return cno;
    }

    public CommentDto setCno(int cno) {
        this.cno = cno;
        return this;
    }

    public int getBno() {
        return bno;
    }

    public CommentDto setBno(int bno) {
        this.bno = bno;
        return this;
    }

    public Integer getPcno() {
        return pcno;
    }

    public CommentDto setPcno(int pcno) {
        this.pcno = pcno;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CommentDto setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getCommenter() {
        return commenter;
    }

    public CommentDto setCommenter(String commenter) {
        this.commenter = commenter;
        return this;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public CommentDto setReg_date(Date reg_date) {
        this.reg_date = reg_date;
        return this;
    }

    public Date getUp_date() {
        return up_date;
    }

    public CommentDto setUp_date(Date up_date) {
        this.up_date = up_date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return Objects.equals(cno, that.cno) && Objects.equals(bno, that.bno) && Objects.equals(pcno, that.pcno) && Objects.equals(comment, that.comment) && Objects.equals(commenter, that.commenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cno, bno, pcno, comment, commenter);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "cno=" + cno +
                ", bno=" + bno +
                ", pcno=" + pcno +
                ", comment='" + comment + '\'' +
                ", commenter='" + commenter + '\'' +
                ", reg_date=" + reg_date +
                ", up_date=" + up_date +
                '}';
    }
}
