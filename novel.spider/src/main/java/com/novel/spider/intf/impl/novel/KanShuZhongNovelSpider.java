package com.novel.spider.intf.impl.novel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.util.NovelSpiderUtil;

public class KanShuZhongNovelSpider extends AbstractNovelSpider {
	private static Logger logger = Logger.getLogger(KanShuZhongNovelSpider.class);  

	@Override
	public List<SpiderNovel> getsNovel(String url,Integer tryTimes) {
		 
		try {
			Elements trs = super.getsTr(url,tryTimes);
			List<SpiderNovel> novels = new ArrayList<SpiderNovel>();
			for (int i = 1,size = trs.size() - 1; i < size; i++) {
				Element a = trs.get(i);
				SpiderNovel novel = new SpiderNovel();
				Elements tds = a.getElementsByTag("td");
				String type = tds.first().text();
				if(type== null || "".equals(type)){
					type = "其他类型";
				}
				novel.setTname(type); // 书籍类型
				novel.setTid(getTypeIdbyName(type));
				novel.setTitle(tds.get(1).text());
				String netUrl = tds.get(1).getElementsByTag("a").first().absUrl("href");
				String nameNum = netUrl.substring(0, netUrl.lastIndexOf("/"));
				nameNum = nameNum.substring(nameNum.lastIndexOf("/") + 1);
				novel.setId(Long.parseLong(nameNum));
 				novel.setNetUrl(netUrl);
				String chapterUrl = tds.get(2).getElementsByTag("a").first().absUrl("href");
				String lastNum = chapterUrl.substring(chapterUrl.lastIndexOf("/")+1).replace(".html", "");
				Long chapterEId = Long.parseLong(lastNum);
				novel.setLatestchapterid(chapterEId);
				novel.setLatestchaptername(tds.get(2).text());
				novel.setAuthor(tds.get(3).text());
				 
				novel.setLastUpdateTime(NovelSpiderUtil.getDate(tds.get(4).text(), "MM-dd"));
				novel.setStatus((byte)NovelSpiderUtil.getNovelStatus(tds.get(5).text()));
				novel.setAddtime(new Date());
				novel.setUpdatetime(new Date());
				//novel.setPlatformId(NovelSiteEnum.getEnumByUrl(url).getId());
				//String lastChapterUrl = tds.get(2).getElementsByTag("a").first().absUrl("href");
			//	String lastChapternameNum = lastChapterUrl.substring(lastChapterUrl.lastIndexOf("/")+1).replace(".html", "");
				novels.add(novel);
			}
			 
			return novels;
		} catch (Exception e) {
			logger.error("获取"+url+"小说列表失败");
			e.printStackTrace();
		}
		return null;
	}

	 
	private Long getTypeIdbyName(String tname) {
		if( "玄幻奇幻".equals(tname)){
			return 1L;
		}else if( "历史穿越".equals(tname)){
			return 2L;
		}else if( "都市言情".equals(tname)){
			return 3L;
		}else if( "武侠修真".equals(tname)){
			return 4L;
		}else if( "网游小说".equals(tname)){
			return 5L;
		}else if( "恐怖灵异".equals(tname)){
			return 6L;
		}else if( "科幻小说".equals(tname)){
			return 7L;
		}else if( "其他类型".equals(tname)){
			return 8L;
		}
		return 8L;
	}
	
	 

}
