package com.novel.spider.intf.impl.chapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.util.NovelSpiderUtil;

public class KanShuZhongChapterSpider extends  AbstractChapterSpider {

	private static Logger logger = Logger.getLogger(KanShuZhongChapterSpider.class);
	// NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url))
	// 根据url 通过httpClient 获取请求的相应体

	/**
	 * 抓取任意网站的章节列表
	 */
	
    @Override
	public Map<String, Object> getsChapter(SpiderNovel novel){
    	logger.info("---抓取 "+novel.getTittle()+"小说章节信息开始---");
		Map<String , Object> map = new HashMap<String , Object>();
		try {
			String result = super.crawl( novel.getNetUrl());
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(novel.getNetUrl());
			
			Map<String,String> context =  NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl( novel.getNetUrl()));
			if(novel.getIntroduction() == null || novel.getImgpath() == null){
				String descselector = context.get("novel-desc-selector");
			    String imgselector = context.get("novel-img-selector");
			    if (descselector != null || imgselector != null) {
					String desc  = doc.select(descselector).get(0).attr("content");
					String imgurl  = doc.select(imgselector).get(0).attr("content");
					novel.setIntroduction(desc.length() > 400 ? desc.substring(0,399) : desc);;
					novel.setImgpath(imgurl);
			    }
			}

			 Elements as = doc.select(context.get("chapter-list-selector"));
			
			// 获取网站最新一章的对象 及最新一章ID 与novel里面的最新章节比较
			Element lastE =  as.last();
			String lastUrl = lastE.absUrl("href");
			String lastNum = lastUrl.substring(lastUrl.lastIndexOf("/")+1).replace(".html", "");
			Long chapterEId = Long.parseLong(lastNum);
			// 说明章节没有更新
			if(novel.getLatestchapterid() != null && novel.getLatestchapterid().longValue() ==chapterEId.longValue()){
				return map;
			} 
			List<SpiderChapter> chapters = new ArrayList<SpiderChapter>();
			String urlSelect = context.get("url");
			for (Element a : as) {
				SpiderChapter chapter = new SpiderChapter();
				chapter.setTittle(a.text());
				String baseUrl = a.absUrl("href");
				chapter.setChapterpath(baseUrl.replace(urlSelect, ""));
				String nameNum = baseUrl.substring(baseUrl.lastIndexOf("/")+1).replace(".html", "");
				Long now = Long.parseLong(nameNum);
				chapter.setId(now);
				chapters.add(chapter);
			}
			// 根据章节ID排序 
			 Collections.sort(chapters, new Comparator<SpiderChapter>() {
					@Override
					public int compare(SpiderChapter o1, SpiderChapter o2) {
						return o1.getId().compareTo(o2.getId());
					}
				});
			long prev = 0L;
			List<SpiderChapter> spiderChapters = new ArrayList<SpiderChapter>(); 
			for (int i = 0,  size = chapters.size(); i < size; i++) {
				SpiderChapter chapter = chapters.get(i);
				Long now = chapter.getId();
				if(i > 0 ){
					// 设置当前章节前一节
					chapter.setPrevid(prev);
				}
				prev = now;
				// 已获取章节不在获取 
				if(novel.getLatestchapterid() != null && now.longValue() < novel.getLatestchapterid().longValue()){
					continue;
				}
				chapter.setNovelId(novel.getId());
				chapter.setcAddTime(new Date());
				
				// 获取下一章节ID
				if(i < size - 1){
					SpiderChapter nextChapter = chapters.get(i+1);
					chapter.setNextid(nextChapter.getId());
				}
				if(novel.getLatestchapterid() != null && chapter.getId().equals(novel.getLatestchapterid())){
					map.put("updateChapter", chapter);
				}else{
					spiderChapters.add(chapter);
				}
				
			}
			novel.setLatestchapterid(spiderChapters.get(spiderChapters.size()-1).getId());
			map.put("insertchapter", spiderChapters);  
			map.put("novel", novel);
			logger.info("---抓取 "+novel.getTittle()+"小说章节信息结束---");
			return map;
		} catch (Exception e) {
			logger.error("---抓取 "+novel.getTittle()+"小说章节信息发生异常---");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		 
		
	}
	
	

}
