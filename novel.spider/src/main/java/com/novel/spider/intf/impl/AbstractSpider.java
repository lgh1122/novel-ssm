package com.novel.spider.intf.impl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.util.NovelSpiderUtil;

public abstract class AbstractSpider  {

	Logger logger = Logger.getLogger(AbstractSpider.class);
	
	// NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url))
	// 根据url 通过httpClient 获取请求的相应体
	protected String crawl(String url) throws Exception {
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			 CloseableHttpResponse httpResponse = httpClient.execute(new HttpGet(url))) {
			HttpEntity entity = httpResponse.getEntity();
			logger.debug(url);
			String result = EntityUtils.toString(entity,NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)).get("charset"));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
