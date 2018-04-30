package com.novel.spider.intf.impl.chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.entitys.Chapter;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.intf.impl.AbstractSpider;
import com.novel.spider.util.NovelSpiderUtil;

public class AbstractChapterSpider extends AbstractSpider  implements IChapterSpider {

	
	// NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url))
	// 根据url 通过httpClient 获取请求的相应体

	/**
	 * 抓取任意网站的章节列表
	 */
	
	@Override
	public List<Chapter> getsChapter(String url) {
		try {
			String result = super.crawl(url);
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Elements as = doc.select(NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)).get("chapter-list-selector"));
			List<Chapter> chapters = new ArrayList<>();
			for (Element a : as) {
				Chapter chapter = new Chapter();
				chapter.setTitle(a.text());
				chapter.setUrl(a.absUrl("href"));
				chapters.add(chapter);
			}
			return chapters;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Map<String, Object> getsChapter(SpiderNovel novel) {
		 
		return null;
	}

}
