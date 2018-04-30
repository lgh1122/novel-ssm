package com.novel.manage.test;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.novel.common.mapper.TbNetMapper;
import com.novel.common.pojo.TbNet;
import com.novel.common.pojo.TbNovel;
import com.novel.manage.converter.ManageConvent;
import com.novel.manage.storage.ChapterProcessor;
import com.novel.manage.storage.NovelProcessor;
import com.novel.manage.storage.impl.KanShuZhongChapterStorageImpl;
import com.novel.manage.storage.impl.KanShuZhongNovelStorageImpl;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.util.NovelSpiderUtil;

public class ManageTest extends BaseJunitTest {
	
	@Autowired
	private   TbNetMapper  netMapper;
	
	
	 @Autowired
	 static Mapper  mapper;
	 
	 
	 @Test
	    public void testNotSameAttributeMapping() {
		    SpiderNovel novel = new SpiderNovel();
			novel.setId(119319L);
			novel.setTittle("逆袭大清");
			novel.setStatus((byte)2);
			novel.setNetUrl("http://www.kanshuzhong.com/book/119319/");
			TbNovel desc = mapper.map(novel, TbNovel.class);
			System.out.println(desc);
	        Assert.assertNotNull(desc);
	    }
	 @Test
	 public void testMapping() {
		 SpiderNovel novel = new SpiderNovel();
		 novel.setId(119319L);
		 novel.setTittle("逆袭大清");
		 novel.setStatus((byte)2);
		 novel.setNetUrl("http://www.kanshuzhong.com/book/119319/");
		 TbNovel desc =  ManageConvent.spiderToTbNovel(novel);
		 System.out.println(desc);
		 
	 }
	 
	 
	 
	 @Test
	    public void testNotSameAttributeMapping2() {
		    TbNovel novel = new TbNovel();
			novel.setId(119319L);
			novel.setTittle("逆袭大清");
			novel.setStatus((byte)2);
			 
			SpiderNovel desc = mapper.map(novel, SpiderNovel.class);
			//mapper.
			System.out.println(desc);
	        Assert.assertNotNull(desc);
	    }
	 
	 
	 @Test
	    public void testManageCOnvent() {
		 try{
			 TbNovel novel = new TbNovel();
				novel.setId(119319L);
				novel.setTittle("逆袭大清");
				novel.setStatus((byte)2);
				novel.setNetid(3L);
				SpiderNovel desc = ManageConvent.tbNovelToSpiderNovel(novel);
				//mapper.
				System.out.println(desc);
		 }catch(Exception e){
			 e.printStackTrace();
		 }   
		 
	        
	    }
	 
	 
	@Test
	public void test2() throws DocumentException{
		
		SAXReader reader = new SAXReader();
		InputStream in =   KanShuZhongNovelStorageImpl.class.getResourceAsStream("/resource/kanshuzhong.xml");
		
		 
		Document doc =	reader.read(in);
		//获取insert url 
        Element root = doc.getRootElement();
        List<Element> rootChildE = root.elements();
        for (Element element : rootChildE) {
			System.out.println(element.getName());
		}
	}
	
	
	 
	
	 @Test  
     public void test0(){  
         System.out.println("第一个测试方法*******"); 
         TbNet  net = netMapper.selectByPrimaryKey(3L);
         System.out.println(net);
         
     }
	 @Test  
	 public void test1(){  
		 System.out.println("第一个测试方法*******"); 
 
		 System.out.println(ManageConvent.netMap);
		 
		 
	 }
	 @Test
	 public void testReadXml(){
		 

			SAXReader reader = new SAXReader();
			try {
			     
			 InputStream in =   NovelSpiderUtil.class.getResourceAsStream("/resource/kanshuzhong.xml");
			 System.out.println(in);
			 
			  Document doc =	reader.read(in);
		 
				Element root = doc.getRootElement();
				Element kanshuzhong = root.element("kanshuzhong");
				List<Element> sites = kanshuzhong.elements("insert");
				for (Element site : sites) {
					List<Element> subs = site.elements();
					Map<String, String> map = new HashMap<>();
					for (Element sub : subs) {
						String title = sub.getName();
						String text = sub.getTextTrim();
						System.out.println(title +"  "+ text);
					}
				}
				
				Element site = kanshuzhong.element("insert");
				Element skip = site.element("skip");
				System.out.println(skip.getName() +" " + skip.getTextTrim());
				Element  urls = site.element("urls");
				List<Element> subs = urls.elements();
				for (Element sub : subs) {
					String title = sub.getName();
					String text = sub.getTextTrim();
					System.out.println("url "+title +"  "+ text);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		 
	 }
	 
	 @Test
	public void testKanshuzhongProcessor() {
		NovelProcessor processor;
		try {
			processor = new KanShuZhongNovelStorageImpl();
			processor.processInsert(102L);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 @Test
		public void testKanshuzhongProcessorUpdate() {
			NovelProcessor processor;
			try {
				processor = new KanShuZhongNovelStorageImpl();
				processor.processUpdate( );
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	 
	 @Test
	 public void testKanshuzhongChapterProcessorInster() {
		 ChapterProcessor processor;
		 try {
			 processor = new KanShuZhongChapterStorageImpl();
			 TbNovel novel = new TbNovel();
				novel.setId(119319L);
				novel.setTittle("逆袭大清");
				novel.setStatus((byte)2);
				novel.setNetid(3L);
			 processor.processChapterInsert(novel);
		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 
	 }
	 

}
