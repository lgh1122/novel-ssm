package com.novel.spider.intf.impl.novel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.INovelSpider;
import com.novel.spider.intf.impl.AbstractSpider;
import com.novel.spider.util.NovelSpiderUtil;

/**
 * 一个抽象的小说列表抓取，已经实现了解析tr元素的方法
 * @author liuguanghui
 *
 */
public abstract class AbstractNovelSpider extends AbstractSpider implements INovelSpider {
	private static Logger logger = Logger.getLogger(AbstractNovelSpider.class);  
	protected Element nextPageElement;
	/** 下一页的url */
	protected String nextPage;
	/**
	 * 默认的抓取方式，最多会尝试{@link INovelSpider#MAX_TRY_TIMES} 次下载
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected Elements getsTr(String url) throws Exception {
		return getsTr(url, INovelSpider.MAX_TRY_TIMES);
	}
	
	protected Elements getsTr(String url, Integer maxTryTimes) throws Exception {
		maxTryTimes = maxTryTimes == null ? INovelSpider.MAX_TRY_TIMES : maxTryTimes;
		Elements as = null;
		for (int i = 0; i < maxTryTimes; i++) {
			try {
				String result = super.crawl(url);
				Map<String,String> context =  NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url));
			    String selector = context.get("novel-selector");
			    if (selector == null ) throw new RuntimeException("url=" + url + "是不被支持的小说网站");
			    Document doc = Jsoup.parse(result);
				doc.setBaseUri(url);
				as = doc.select(selector);
				
				String nextPageSelector = context.get("novel-page-next-selector");
				if(nextPageSelector != null){
					Elements nextPageE = doc.select(nextPageSelector);
					nextPageElement = nextPageE == null ? null : nextPageE.first();
					if (nextPageElement != null) {
						nextPage = nextPageElement.absUrl("href");
					} else {
						nextPage = "";
					}
				}else{
					nextPage = "";
				}
				return as;
			} catch (Exception e) {
				 
				logger.debug("第" +(i+1)+"次获取"+url+" 失败");  
				e.printStackTrace();
			}
			
		}
		logger.error(url + "尝试了"+maxTryTimes+"依然获取当前页小说列表失败");  
		throw new RuntimeException( url + "尝试了"+maxTryTimes+"依然获取当前页小说列表失败");
		
	}
	
	@Override
	public boolean hasNext() {
		 
		return !nextPage.isEmpty();
	}
	
	@Override
	public String next() {
		 
		return nextPage;
	}
	/**
	 * 这里需要返回一个自定义的迭代器
	 */
	@Override
	public Iterator<List<SpiderNovel>> iterator(String firstPage, Integer maxTryTimes) {
		/*List<String> list = new ArrayList<String>();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			iter.next();
		}*/
		nextPage = firstPage;
		return new NovelIterator(maxTryTimes);
	}
	
	@SuppressWarnings("unused")
	private class NovelIterator implements Iterator<List<SpiderNovel>>{
		private Integer maxTryTimes;
		public NovelIterator(Integer maxTryTimes) {
			this.maxTryTimes = maxTryTimes;
		}
		@Override
		public boolean hasNext() {
			return AbstractNovelSpider.this.hasNext();
		}
		@Override
		public List<SpiderNovel> next() {
			return getsNovel(nextPage,maxTryTimes);
		}

		@Override
		public void remove() {
			
		}
		
	}

}
