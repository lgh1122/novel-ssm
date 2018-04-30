package com.novel.spider.intf.impl.novel;

import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.INovelDescSpider;
import com.novel.spider.intf.INovelSpider;
import com.novel.spider.intf.impl.AbstractSpider;
import com.novel.spider.util.NovelSpiderUtil;

public class KanShuZhongNovelDescSpider extends AbstractSpider implements INovelDescSpider {

	private static Logger logger = Logger.getLogger(KanShuZhongNovelDescSpider.class);
	 
	
	/**
	 * 默认的抓取方式，最多会尝试{@link INovelSpider#MAX_TRY_TIMES} 次下载
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@Override
	public SpiderNovel getsNovelDescImg(String url) throws Exception {
		return getsNovelDescImg(url, INovelSpider.MAX_TRY_TIMES);
	}
	@Override
	public SpiderNovel getsNovelDescImg(String url, Integer maxTryTimes) throws Exception {
		maxTryTimes = maxTryTimes == null ? INovelSpider.MAX_TRY_TIMES : maxTryTimes;
		 
		SpiderNovel novel = new SpiderNovel();
		for (int i = 0; i < maxTryTimes; i++) {
			try {
				String result = super.crawl(url);
				Map<String,String> context =  NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url));
			    String descselector = context.get("novel-desc-selector");
			    String imgselector = context.get("novel-img-selector");
			    if (descselector == null || imgselector == null) throw new RuntimeException("url=" + url + "是不被支持获取简介和书籍图片的小说网站");
			    Document doc = Jsoup.parse(result);
				doc.setBaseUri(url);
				String desc  = doc.select(descselector).get(0).attr("content");
				String imgurl  = doc.select(imgselector).get(0).attr("content");
				novel.setIntroduction(desc);;
				novel.setImgpath(imgurl);
				return novel;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		logger.error(url + "尝试了"+maxTryTimes+"依然获取简介失败");
		throw new RuntimeException( url + "尝试了"+maxTryTimes+"依然获取简介失败");
		
	}

}
