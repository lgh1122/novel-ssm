package com.novel.spider.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.novel.spider.NovelSiteEnum;

public final class NovelSpiderUtil {
	
	private static Logger logger = Logger.getLogger(NovelSpiderUtil.class);
	private static final Map<NovelSiteEnum,Map<String,String>> CONTEXT_MAP = new HashMap<>();
	
	static {
 		init();
	}
	private  static void init(){
		SAXReader reader = new SAXReader();
		try {
		     
		 logger.info("读取规则文件Spider-Rule.xml  "+NovelSpiderUtil.class.getResource("/Spider-Rule.xml").getPath());
		 InputStream in =   NovelSpiderUtil.class.getResourceAsStream("/Spider-Rule.xml");
		 System.out.println(in);
		 // reader.read(in)	
		 // Document doc =	reader.read(new File("conf/Spider-Rule.xml"));
		  Document doc =	reader.read(in);
	 
			Element root = doc.getRootElement();
			List<Element> sites = root.elements("site");
			for (Element site : sites) {
				List<Element> subs = site.elements();
				Map<String, String> map = new HashMap<>();
				for (Element sub : subs) {
					String title = sub.getName();
					String text = sub.getTextTrim();
					map.put(title, text);
				}
				CONTEXT_MAP.put(NovelSiteEnum.getEnumByUrl(map.get("url")), map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拿到对应网站的解析规则
	 */
	public static Map<String,String> getContext(NovelSiteEnum novelEnum){
		
		return CONTEXT_MAP.get(novelEnum);
	}
	
	public static int getNovelStatus(String status){
		if(status.contains("连载")){
			return 1;
		}else if(status.contains("完成")||status.contains("完结")){
			return 2;
		}else{
			return 3;
		}
	}
	
	
	public static Date getDate(String dateStr,String pattern) throws ParseException{
		if(pattern.equals("MM-dd")){
			pattern = "yyyy-MM-dd";
			/*if(Integer.parseInt(dateStr.split("-")[0])>(getDateField(Calendar.MONTH)+1)&&Integer.parseInt(dateStr.split("-")[1])>7){
				dateStr = (getDateField(Calendar.YEAR)-1)+"-"+dateStr;
			}else{
				
			}
			*/
			dateStr = getDateField(Calendar.YEAR)+"-"+dateStr;
		}
		 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		 Date d = sdf.parse(dateStr);
		 if(d.getTime() > new Date().getTime()){
		    Calendar c = Calendar.getInstance();
		    c.setTime(d);
	        c.add(Calendar.YEAR, -1);
	        Date y = c.getTime();
	        d = y;
		 }
		 return d;
	}
	/**
	 * 获取指定年、月、日 在本时刻的单独值 字符串 
	 * 
	 * @param field
	 * @return
	 */
	public static int getDateField(int field){
		Calendar cal = Calendar.getInstance();
		return cal.get(field) ;
	}

 
	
	/**
	 * 多个文件合并为一个文件，合并规则：按文件名分割排序
	 * @param path 基础目录，该根目录下的所有文本文件都会被合并到 mergeToFile
	 * @param mergeToFile 被合并的文本文件，这个参数可以为null,合并后的文件保存在path/merge.txt
	 */
	public static void multiFileMerge(String path, String mergeToFile, boolean deleteThisFile){
		mergeToFile = mergeToFile == null ? path +"/merge.txt" : path+"/"+ mergeToFile;
		File[] files = new File(path).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				int file1 = Integer.parseInt(o1.getName().split("\\.")[0]);
				int file2 = Integer.parseInt(o2.getName().split("\\.")[0]);
				System.out.println(o1.getName());
				if(file1 > file2){
					return 1;
				}else if(file1 == file2){
					return 0;
				}else{
					return -1;
				}
				 
			}
		});
		
		PrintWriter  out = null;
		try {
			out = new PrintWriter (new OutputStreamWriter(new FileOutputStream(mergeToFile)));
			for (File file : files) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			while ((line = reader.readLine())!= null) {
				out.println(line);
			}
			reader.close();
			if(deleteThisFile){
				file.delete();
			}
			}
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


}
