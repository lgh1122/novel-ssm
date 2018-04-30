package com.novel.spider.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.novel.spider.entitys.SpiderChapter;

public class CommonUtil {
	
	public static Map<String, List<SpiderChapter>> subChapterList(List<SpiderChapter> chapters, int size){
		Map<String, List<SpiderChapter>> subListMap = new HashMap<String, List<SpiderChapter>>();
		int maxThreadSize = (int) Math.ceil(chapters.size() * 1.0 / size);
		for (int i = 0; i < maxThreadSize; i++) {
			int fromIndex = i * size;
			int toIndex = i == maxThreadSize - 1 ? chapters.size() : (i + 1) * size;
			subListMap.put(fromIndex + "-" + toIndex, chapters.subList(fromIndex, toIndex)); 
		}
		return subListMap;
	}
	
	@SuppressWarnings("resource")
	public static boolean writeFile(String strUrl,String path, String fileName) throws Exception {
		boolean flag = false;
		InputStream is = null;

		OutputStream os = null;
		try {
			
			URL url = new URL(strUrl);
			is = url.openStream();
			File f = new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			os = new FileOutputStream(path+"\\" + fileName);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace(); 
		}finally {
			if(is != null){
				is.close();
			}
			if(os !=null){
				os.close();
			}
		}
		
		return flag;

	}

}
