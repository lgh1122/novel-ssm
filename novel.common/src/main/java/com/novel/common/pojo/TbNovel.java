package com.novel.common.pojo;

import java.util.Date;

public class TbNovel extends TbNovelKey {
    private String tittle;

    private String author;

    private Long tid;

    private String tname;

    private String introduction;

    private String imgpath;

    private String latestchaptername;

    private Long latestchapterid;

    private Date addtime;

    private Date updatetime;

    private Byte status;

    private Byte vaild;

    private Byte ishaschapter;

    private Integer clicknum;

    private Integer downnum;

    private Long chapteroldid;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getLatestchaptername() {
        return latestchaptername;
    }

    public void setLatestchaptername(String latestchaptername) {
        this.latestchaptername = latestchaptername == null ? null : latestchaptername.trim();
    }

    public Long getLatestchapterid() {
        return latestchapterid;
    }

    public void setLatestchapterid(Long latestchapterid) {
        this.latestchapterid = latestchapterid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getVaild() {
        return vaild;
    }

    public void setVaild(Byte vaild) {
        this.vaild = vaild;
    }

    public Byte getIshaschapter() {
        return ishaschapter;
    }

    public void setIshaschapter(Byte ishaschapter) {
        this.ishaschapter = ishaschapter;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }

    public Integer getDownnum() {
        return downnum;
    }

    public void setDownnum(Integer downnum) {
        this.downnum = downnum;
    }

    public Long getChapteroldid() {
        return chapteroldid;
    }

    public void setChapteroldid(Long chapteroldid) {
        this.chapteroldid = chapteroldid;
    }
}