package com.novel.manage.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 用于获取配置文件中的任务列表
 * @author liuguanghui
 *
 */
public class InitTask {
	public static Logger logger = Logger.getLogger(InitTask.class);
	
	public static final Map<String,Map<String,Object>> CONTEXT_MAP = new HashMap<String,Map<String,Object>>();

	static{
		init();
	}
	/**
	 * 读取获取书籍列表URL配置
	 */
	public static void init(){
		SAXReader reader = new SAXReader();
		try {   
			InputStream in =   InitTask.class.getResourceAsStream("/resource/kanshuzhong.xml");
			
			logger.debug(in);
			Document doc =	reader.read(in);
			//获取insert url 
	        Element root = doc.getRootElement();
	        @SuppressWarnings("unchecked")
			List<Element> rootChildE = root.elements();
	        for (Element element : rootChildE) {
				Map<String,Object> child = new TreeMap<>();	
				Element insertSiteE = element.element("insert");
				Element insertSkipE = insertSiteE.element("skip");
				int insertSkip = Integer.parseInt(insertSkipE.getTextTrim());
				child.put(SystemConstants.INSERT_SKIP, insertSkip);
				Element  urlsE = insertSiteE.element("urls");
				@SuppressWarnings("unchecked")
				List<Element> subs = urlsE.elements();
				Map<String,String> insertTask = new TreeMap<String,String>();
				for (int i = 0; i < subs.size(); i++) {
			    	Element sub = subs.get(i);
			    	String title = sub.getName();
					String text = sub.getTextTrim();
					insertTask.put(title+i, text);
				} 
				child.put(SystemConstants.INSERT_TASK, insertTask);
				
				Element updateSiteE = element.element("update");
				Element updaeSkipE = updateSiteE.element("skip");
				int updateSkip = Integer.parseInt(updaeSkipE.getTextTrim()); 
				child.put(SystemConstants.UPDATE_SKIP, updateSkip);
				Element  updateurlsE = updateSiteE.element("urls");
				@SuppressWarnings("unchecked")
				List<Element> updaetsubs = updateurlsE.elements();
				Map<String,String> updateTask = new TreeMap<String,String>();
				for (int i = 0; i < updaetsubs.size(); i++) {
			    	Element sub = updaetsubs.get(i);
			    	String title = sub.getName();
					String text = sub.getTextTrim();
					updateTask.put(title+i, text);
				} 
				child.put(SystemConstants.UPDATE_TASK, updateTask);
				CONTEXT_MAP.put(element.getName() ,child);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
 }
	
	public static Map<String,Object> getContext(String string){
		return CONTEXT_MAP.get(string);
	}
	public static int getInsertSkip(String string){
		Map<String,Object> map = getContext( string);
		return (int) map.get(SystemConstants.INSERT_SKIP);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getInsertTask(String string){
		Map<String,Object> map = getContext( string);
		return  (Map<String, String>) map.get(SystemConstants.INSERT_TASK);
	}
	
	
	public static int getUpdateSkip(String string){
		Map<String,Object> map = getContext( string);
		return (int) map.get(SystemConstants.UPDATE_SKIP);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getUpdateTask(String string){
		Map<String,Object> map = getContext( string);
		return  (Map<String, String>) map.get(SystemConstants.UPDATE_TASK);
	}
	
	

}
