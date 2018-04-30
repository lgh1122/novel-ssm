package com.novel.spider.entitys;

import java.util.Date;

public class SpiderChapter extends SpiderChapterKey {
    private String tittle;

    private String chapterpath;

    private String cPath;

    private Long previd;

    private Long nextid;

    private Date cAddTime;

     

    public String getcPath() {
        return cPath;
    }

    public void setcPath(String cPath) {
        this.cPath = cPath == null ? null : cPath.trim();
    }

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

    public Date getcAddTime() {
        return cAddTime;
    }

    public void setcAddTime(Date cAddTime) {
        this.cAddTime = cAddTime;
    }

	@Override
	public String toString() {
		return "SpiderChapter [tittle=" + tittle + ", chapterpath=" + chapterpath + ", cPath=" + cPath + ", previd="
				+ previd + ", nextid=" + nextid + ", cAddTime=" + cAddTime + "]";
	}

	 
    
    
}