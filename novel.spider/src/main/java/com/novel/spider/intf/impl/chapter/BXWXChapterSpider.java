package com.novel.spider.intf.impl.chapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.util.NovelSpiderUtil;


public class BXWXChapterSpider extends AbstractChapterSpider {
	
	
	@Override
	public List<Chapter> getsChapter(String url) {
		List<Chapter> chapters = super.getsChapter(url);
	    Collections.sort(chapters, new Comparator<Chapter>() {

		@Override
		public int compare(Chapter o1, Chapter o2) {
			 String o1Url = o1.getUrl();
			 String o2Url = o2.getUrl();
			 String o1Index =o1Url.substring(o1Url.lastIndexOf("/")+1, o1Url.lastIndexOf("."));
			 String o2Index =o2Url.substring(o2Url.lastIndexOf("/")+1, o2Url.lastIndexOf("."));
				
			return o1Index.compareTo(o2Index);
		}
	});
			return chapters;
		
		
	}

}
