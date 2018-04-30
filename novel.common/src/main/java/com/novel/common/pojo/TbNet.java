package com.novel.common.pojo;

import java.util.Date;

public class TbNet {
    private Long id;

    private String netname;

    private String baseurl;

    private String fullurl;

    private String charset;

    private String novelurl;

    private String chapterurl;

    private String chapterinfourl;

    private String imageurl;

    private Date addtime;

    private String paramdata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNetname() {
        return netname;
    }

    public void setNetname(String netname) {
        this.netname = netname == null ? null : netname.trim();
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl == null ? null : baseurl.trim();
    }

    public String getFullurl() {
        return fullurl;
    }

    public void setFullurl(String fullurl) {
        this.fullurl = fullurl == null ? null : fullurl.trim();
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset == null ? null : charset.trim();
    }

    public String getNovelurl() {
        return novelurl;
    }

    public void setNovelurl(String novelurl) {
        this.novelurl = novelurl == null ? null : novelurl.trim();
    }

    public String getChapterurl() {
        return chapterurl;
    }

    public void setChapterurl(String chapterurl) {
        this.chapterurl = chapterurl == null ? null : chapterurl.trim();
    }

    public String getChapterinfourl() {
        return chapterinfourl;
    }

    public void setChapterinfourl(String chapterinfourl) {
        this.chapterinfourl = chapterinfourl == null ? null : chapterinfourl.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getParamdata() {
        return paramdata;
    }

    public void setParamdata(String paramdata) {
        this.paramdata = paramdata == null ? null : paramdata.trim();
    }

	@Override
	public String toString() {
		return "TbNet [id=" + id + ", netname=" + netname + ", baseurl=" + baseurl + ", fullurl=" + fullurl
				+ ", charset=" + charset + ", novelurl=" + novelurl + ", chapterurl=" + chapterurl + ", chapterinfourl="
				+ chapterinfourl + ", imageurl=" + imageurl + ", addtime=" + addtime + ", paramdata=" + paramdata + "]";
	}
    
    
}