package com.novel.spider.entitys;

import java.util.Date;

public class SpiderNovel {
    private Long id;  // 书籍编号

    private String tittle;  // 书籍名称

    private String author;  // 作者

    private String tname;  //类型

    private Long tid; //类型ID

    private String netUrl;  // 源地址

    private Long latestchapterid;  // 最新章节地址
    private String latestchaptername;  // 最新章节地址

    private Byte status;   // 连载 or 完本

    

    private String introduction;  // 简介

    private String imgpath; // 图片

    private Date addtime; //添加时间

    private Date updatetime; //更新时间

     
    
    private Date lastUpdateTime;  // 最新更新时间 根据网站章节更新获取
    
    private char firstLetter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		this.author = author;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getNetUrl() {
		return netUrl;
	}

	public void setNetUrl(String netUrl) {
		this.netUrl = netUrl;
	}

	public Long getLatestchapterid() {
		return latestchapterid;
	}

	public void setLatestchapterid(Long latestchapterid) {
		this.latestchapterid = latestchapterid;
	}

	public String getLatestchaptername() {
		return latestchaptername;
	}

	public void setLatestchaptername(String latestchaptername) {
		this.latestchaptername = latestchaptername;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	 

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
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

 

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public char getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(char firstLetter) {
		this.firstLetter = firstLetter;
	}

	@Override
	public String toString() {
		return "SpiderNovel [id=" + id + ", tittle=" + tittle + ", author=" + author + ", tname=" + tname + ", tid="
				+ tid + ", netUrl=" + netUrl + ", latestchapterid=" + latestchapterid + ", latestchaptername="
				+ latestchaptername + ", status=" + status +   ", introduction=" + introduction
				+ ", imgpath=" + imgpath + ", addtime=" + addtime + ", updatetime=" + updatetime  
				+ ", lastUpdateTime=" + lastUpdateTime + ", firstLetter="
				+ firstLetter + "]";
	}  

    
    
   
    
    
}