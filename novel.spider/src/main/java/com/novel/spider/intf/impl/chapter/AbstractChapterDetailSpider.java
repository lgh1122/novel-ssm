package com.novel.spider.intf.impl.chapter;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.entitys.SpiderChapterDetail;
import com.novel.spider.intf.IChapterDetailSpider;
import com.novel.spider.intf.impl.AbstractSpider;
import com.novel.spider.util.NovelSpiderUtil;

public abstract class AbstractChapterDetailSpider extends AbstractSpider implements IChapterDetailSpider {

	@Override
	public SpiderChapterDetail getChapterDetail(String url) {
		try {
			String result = super.crawl(url);
			result = result.replace("&nbsp;", "${nbsp}").replace("<br />", "${line}").replace("<br/>", "${line}");
			//result = result.replace("&nbsp;", "  ").replace("<br />", "\n").replace("<br/>", "\n");
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Map<String, String> contexts = NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url));

			// 拿章节标题
			String titleSector = contexts.get("chapter-detail-title-selector");
			String[] splits = titleSector.split("\\,");
			splits = parseSelector(splits);
			//System.out.println(titleSector+" "+splits[0] +" " + splits[1]);
			SpiderChapterDetail detail = new SpiderChapterDetail();
			Elements tittleE = doc.select(splits[0]);
			String title = tittleE.get(Integer.parseInt(splits[1])).text();
			detail.setTitle(title);
			// 拿章节内容
			String contentSector = contexts.get("chapter-detail-content-selector");
			Element e12 = doc.select(contentSector).first();
			String str = e12.text();//.replace("&nbsp;", "${nbsp}").replace("<br />", "${line}").replace("<br/>", "\n");
			//String content = e12.text(str).text().replace("${nbsp}", "&nbsp;").replace("${line}", "<br />").replace("${brbr}", "<br/>");
			String content = e12.text(str).text().replace("${nbsp}", "  ").replace("${line}", "\n");
			detail.setContent(content);
			
			//拿章节内容
			// String contentSelector = contexts.get("chapter-detail-content-selector");
			//detail.setContent(doc.select(contentSelector).first().text());
			// 拿前一章链接
			String prevSector = contexts.get("chapter-detail-prev-selector");
			splits = prevSector.split("\\,");
			splits = parseSelector(splits);
			Elements e = doc.select(splits[0]);
			detail.setPrev(e.get(Integer.parseInt(splits[1])).absUrl("href"));
			
			//拿后一章的地址
			String nextSelector = contexts.get("chapter-detail-next-selector");
			splits = nextSelector.split("\\,");
			splits = parseSelector(splits);
			detail.setNext(doc.select(splits[0]).get(Integer.parseInt(splits[1])).absUrl("href"));
			return detail;
		} catch (Exception e) {
			System.err.println("获取章节内容失败");
			e.printStackTrace();
		}

		return null;
	}

	private String[] parseSelector(String[] splits) {
		String str[] = new String[2];
		if (splits.length == 1) {
			str[0] = splits[0];
			str[1] = "0";
			return str;
		} else {
			return splits;
		}

	}

}
