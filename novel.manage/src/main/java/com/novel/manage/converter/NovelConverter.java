package com.novel.manage.converter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.novel.common.pojo.TbNovel;
import com.novel.spider.entitys.SpiderNovel;

@Deprecated
public class NovelConverter implements CustomConverter{

	public Object convert(Object destination, Object source, 
		      Class destClass, Class sourceClass) {
		    if (source == null) {
		      return null;
		    }
		    
		    if (source instanceof TbNovel) {
		    	SpiderNovel dest = null;
		       
		      if (destination == null) {
		        dest = new SpiderNovel();
		      } else {
		        dest = (SpiderNovel) destination;
		      }
		      dest.setNetUrl("http://www.kanshuzhong.com/book/"+((TbNovel)source).getId());
		      
		      return dest;
		    } else if (source instanceof SpiderNovel) {
		      TbNovel dest = null;
		      if(destination == null){
		    	  dest =  new TbNovel();
		      }else{
		    	  dest = (TbNovel) destination;  
		      }
		      dest.setIntroduction(((SpiderNovel)source).getStatus() == 1 ? "连载" : "完成");
		      return dest;
		    } else {
		      throw new MappingException("Converter TestCustomConverter "
		          + "used incorrectly. Arguments passed in were:"
		          + destination + " and " + source);
		    }
		    }
}
