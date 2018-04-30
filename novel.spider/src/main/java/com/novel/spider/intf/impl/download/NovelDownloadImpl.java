package com.novel.spider.intf.impl.download;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.novel.spider.configuration.Configuration;
import com.novel.spider.entitys.Chapter;
import com.novel.spider.entitys.SpiderChapterDetail;
import com.novel.spider.intf.IChapterDetailSpider;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.intf.INovelDownload;
import com.novel.spider.util.ChapterDetailSpiderFactory;
import com.novel.spider.util.ChapterSpiderFactory;

/**
 * 通过多线程下载网站小说
 * @author liuguanghui
 *
 */
public class NovelDownloadImpl implements INovelDownload {

	 
	/**
	 * 如何实现多线程下载任意网站的小说 1.拿到该网站的某本小说的所有章节：章节列表
	 * 2.通过计算，将这些章节分配给指定数量的线程，让他们去解析，然后保存到文本文件中
	 * 3.通知主线程，将这些零散的小文件合并成一个大文件。最后将那些分片的小文件删除掉。
	 */
	@Override
	public List<Chapter> downLoad(String url, Configuration config, List<Chapter> list) {
		// 根据URL 获取对应的目录信息集合
		List<Chapter> chapterList = null;
		if (list != null && list.size() > 0) {
			chapterList = list;
			list = new ArrayList<Chapter>();
		} else {
			IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(url);
			chapterList = chapterSpider.getsChapter(url);
			list = new ArrayList<Chapter>();
		}

		// 根据集合来决定创建多少个线程处理任务
		int size = config.getSize();
		int maxThreadSize = (int) Math.ceil(chapterList.size() * 1.0 / size);
		Map<String, List<Chapter>> downloadTaskAlloc = new HashMap<>();
		for (int i = 0; i < maxThreadSize; i++) {
			int fromIndex = i * config.getSize();
			int toIndex = i == maxThreadSize - 1 ? chapterList.size() : (i + 1) * config.getSize();
			System.out.println(fromIndex + "------" + toIndex + ":" + chapterList.get(fromIndex).getTitle());
			System.out.println(fromIndex + "------" + toIndex + ":" + chapterList.get(toIndex - 1).getTitle());
			downloadTaskAlloc.put(fromIndex + "-" + toIndex, chapterList.subList(fromIndex, toIndex));
			 
		}
		// 分配好之后 ， 就要开始创建线程池了
		ExecutorService service = Executors.newFixedThreadPool(maxThreadSize);
		Set<String> ketSet = downloadTaskAlloc.keySet();
		List<Future<List<Chapter>>> tasks = new ArrayList<>();
		// 通过这两段代码就可以创建缺失的路径

		String nameNum = url.substring(0, url.lastIndexOf("/"));
		nameNum = nameNum.substring(nameNum.lastIndexOf("/") + 1);
		String savePath = config.getPath() + "/" + nameNum;
		new File(savePath).mkdirs();
		for (String key : ketSet) {
			tasks.add(service.submit(new DownloadCallable(savePath, downloadTaskAlloc.get(key))));
		}
		service.shutdown();
		for (Future<List<Chapter>> future : tasks) {
			try {
				List<Chapter> err = future.get();
				System.out.println("当前线程有" + err.size() + "章节下载失败");
				list.addAll(err);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		if(list.size() == 0 && true){
			
		}
		
		return list;
	}
	
	
	class DownloadCallable implements Callable<List<Chapter>>{
		// 要下载的章节集合
		private List<Chapter> chapters;
		private String path;
		public DownloadCallable(String path, List<Chapter> chapters) {
			this.path = path;
			this.chapters = chapters;
		}
		/**
		 * @return 下载失败的章节集合
		 */
		@Override
		public List<Chapter> call() throws Exception {
			PrintWriter out = null ;
			List<Chapter> errChapter = new ArrayList<Chapter>() ;
			try   {
				/*PrintWriter out = new PrintWriter(new File(path));*/
				for(Chapter chapate : chapters){
					IChapterDetailSpider spider = ChapterDetailSpiderFactory.getChapterDetailSpider(chapate.getUrl());
			        String chapterDetailUrl = chapate.getUrl();
					SpiderChapterDetail cd = spider.getChapterDetail(chapterDetailUrl);
			        String nameNum = chapterDetailUrl.substring(chapterDetailUrl.lastIndexOf("/")+1).replace(".html", "");
			        out =  new PrintWriter(new File(path+"/" +nameNum+".txt"), "GBK");
			        if(cd == null){
						errChapter.add(chapate);
						System.err.println("下载失败章节 "+chapate.getTitle());
					}else{
			        out.println(cd.getTitle());
					out.print(cd.getContent());
					}
			        out.close();
			      
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				//throw new RuntimeException(e);
			}
			return errChapter;
		}
		
	}


	 

}
