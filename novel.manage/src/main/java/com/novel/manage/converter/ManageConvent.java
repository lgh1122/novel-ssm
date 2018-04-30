package com.novel.manage.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;

import com.novel.common.pojo.TbNet;
import com.novel.common.pojo.TbNovel;
import com.novel.spider.entitys.SpiderNovel;

public class ManageConvent {

	public static Map<Long,TbNet> netMap = new HashMap<Long,TbNet>();

	public static  Mapper mapper;
	/**
	 * spiderNovel 转换成 TbNovel
	 * @param spiderNovel
	 * @return
	 */
	public static TbNovel spiderToTbNovel(SpiderNovel spiderNovel){
		TbNovel tbNovel = mapper.map(spiderNovel, TbNovel.class);
		 
		TbNet net = getTbNetfromMap(spiderNovel.getNetUrl());
		if(spiderNovel.getImgpath() != null){
			tbNovel.setImgpath(spiderNovel.getImgpath().replace(net.getFullurl(), ""));
		}
		tbNovel.setNetid(net.getId());
		return tbNovel;
	}
	/**
	 * spiderNovel 集合 转换成 TbNovel 集合
	 * @param spiderNovel
	 * @return
	 */
	public static List<TbNovel> spiderToTbNovelList(List<SpiderNovel> spidernovels){
		List<TbNovel> tbNovels = new ArrayList<TbNovel>();
		if(spidernovels == null || spidernovels.size()==0){
			return null;
		}
		TbNet net = getTbNetfromMap(spidernovels.get(0).getNetUrl());
		for (SpiderNovel spiderNovel : spidernovels) {
			TbNovel tbNovel = mapper.map(spiderNovel, TbNovel.class);
			if(spiderNovel.getImgpath() != null){
				tbNovel.setImgpath(spiderNovel.getImgpath().replace(net.getFullurl(), ""));
			}
			tbNovel.setNetid(net.getId());
			tbNovels.add(tbNovel);
		}		
		return tbNovels;
	}
	
	
	public static TbNet  getTbNetfromMap(String url){
		for (Map.Entry<Long, TbNet> entry : netMap.entrySet()) {
			   
			   TbNet value = entry.getValue();  
			   if(url!=null && url.contains(value.getBaseurl())){
				   return value;
			   }
		}
		return null;
	}
	
	
	
	/**
	 * spiderNovel 转换成 TbNovel
	 * @param spiderNovel
	 * @return
	 */
	public static SpiderNovel tbNovelToSpiderNovel(TbNovel tbNovel ){
		SpiderNovel spiderNovel = mapper.map(tbNovel, SpiderNovel.class);
		//NovelSiteEnum siteenum =  NovelSiteEnum.getEnumById(Long.bitCount( (tbNovel.getNetid())));
		TbNet net = netMap.get(tbNovel.getNetid());
		if(tbNovel.getImgpath() != null){
			spiderNovel.setImgpath(net.getFullurl()+spiderNovel.getImgpath());	
		}
		spiderNovel.setNetUrl(net.getNovelurl().replace("${novelurl}", tbNovel.getId()+""));
		return spiderNovel;
	}
	
	
}
