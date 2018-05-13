package com.novel.spider.entitys;

import java.util.Date;

public class SpiderChapter extends SpiderChapterKey {
    private String title;

    private String chapterPath;

    private String cPath;

    private Long prevId;

    private Long nextId;

    private Date cAddTime;

    private Long novelId;


    public Long getNovelId() {
        return novelId;
    }

    public void setNovelId(Long novelId) {
        this.novelId = novelId;
    }

    public String getCPath() {
        return cPath;
    }

    public void setCPath(String cPath) {
        this.cPath = cPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getChapterPath() {
        return chapterPath;
    }

    public void setChapterPath(String chapterPath) {
        this.chapterPath = chapterPath == null ? null : chapterPath.trim();
    }

    public Long getPrevId() {
        return prevId;
    }

    public void setPrevId(Long prevId) {
        this.prevId = prevId;
    }

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }

    public Date getCAddTime() {
        return cAddTime;
    }

    public void setCAddTime(Date cAddTime) {
        this.cAddTime = cAddTime;
    }

	@Override
	public String toString() {
		return "SpiderChapter [title=" + title + ", chapterPath=" + chapterPath + ", cPath=" + cPath + ", prevId="
				+ prevId + ", nextId=" + nextId + ", cAddTime=" + cAddTime + "]";
	}

	 
    
    
}