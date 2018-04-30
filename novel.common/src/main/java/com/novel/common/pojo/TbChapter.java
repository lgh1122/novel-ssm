package com.novel.common.pojo;

public class TbChapter extends TbChapterKey {
    private String tittle;

    private String chapterpath;

    private Long previd;

    private Long nextid;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }

    public String getChapterpath() {
        return chapterpath;
    }

    public void setChapterpath(String chapterpath) {
        this.chapterpath = chapterpath == null ? null : chapterpath.trim();
    }

    public Long getPrevid() {
        return previd;
    }

    public void setPrevid(Long previd) {
        this.previd = previd;
    }

    public Long getNextid() {
        return nextid;
    }

    public void setNextid(Long nextid) {
        this.nextid = nextid;
    }
}