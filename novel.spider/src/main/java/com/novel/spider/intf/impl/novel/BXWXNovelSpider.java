package com.novel.spider.intf.impl.novel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.util.NovelSpiderUtil;

public class BXWXNovelSpider extends AbstractNovelSpider {

	@Override
	public List<SpiderNovel> getsNovel(String url ,Integer tryTimes) {
		 
		try {
			Elements trs = super.getsTr(url,tryTimes);
			List<SpiderNovel> novels = new ArrayList<SpiderNovel>();
			for (int i = 1,size = trs.size(); i < size; i++) {
				Element a = trs.get(i);
				SpiderNovel novel = new SpiderNovel();
				Elements tds = a.getElementsByTag("td");
				novel.setTitle(tds.first().text());
				//String url = tds.first().absUrl("href");
				//novel.setUrl(tds.get(1).getElementsByTag("a").first().absUrl("href"));
				//novel.setLastUpdateChapterUrl(tds.get(1).getElementsByTag("a").first().absUrl("href"));
				//novel.setLastUpdateChapter(tds.get(1).text());
				//novel.setAuthor(tds.get(2).text());
				//novel.setLastUpdateTime(NovelSpiderUtil.getDate(tds.get(4).text(), "yy-MM-dd"));
				//novel.setStatus(NovelSpiderUtil.getNovelStatus(tds.get(5).text()));
				//novel.setAddTime(new Date());
				//novel.setPlatformId(NovelSiteEnum.getEnumByUrl(url).getId());
				novels.add(novel);
			}
			 
			return novels;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
