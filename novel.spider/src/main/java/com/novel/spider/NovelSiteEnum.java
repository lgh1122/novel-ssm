package com.novel.spider;

/**
 * 已经被支持的小说网站枚举
 * 
 * @author liuguanghui
 *
 */
public enum NovelSiteEnum {
	DingDianXiaoShuo(1, "x23us.com"), BiQuGe(2, "biquge.tw"),Kanshuzhong(3,"kanshuzhong.com"),
	XBXWX(4,"xbxwx.net"),BXWX(5,"bxwx9.org") ;
	private int id;
	private String url;

	private NovelSiteEnum(int id, String url) {
		this.id = id;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static NovelSiteEnum getEnumById(int id) {
		switch (id) {
		case 1:
			return DingDianXiaoShuo;

		case 2:
			return NovelSiteEnum.BiQuGe;


		default:
			throw new RuntimeException("id=" + id + "是不被支持的小说网站");

		}
	}
	
	public static NovelSiteEnum getEnumByUrl(String url) {
		for (NovelSiteEnum novelEnum : values()) {
			if(url.contains(novelEnum.url)){
				return novelEnum;
			}
		}
		throw new RuntimeException("url=" + url + "是不被支持的小说网站");
	
	}
}
