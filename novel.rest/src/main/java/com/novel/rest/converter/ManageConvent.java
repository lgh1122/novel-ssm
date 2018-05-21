package com.novel.rest.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.novel.common.pojo.TbChapter;
import com.novel.spider.entitys.SpiderChapter;
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
	 * @param spidernovels
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


	/**
	 * spiderNovel 集合 转换成 TbNovel 集合
	 * @param tbNovels
	 * @return
	 */
	public static List<SpiderNovel > tbNovelToSpiderNovelList(List<TbNovel> tbNovels){
		List<SpiderNovel> spiderNovels = new ArrayList<SpiderNovel>();
		if(tbNovels == null || tbNovels.size()==0){
			return null;
		}
		TbNet net = getTbNetfromMapByID(tbNovels.get(0).getNetid());
		for (TbNovel tbNovel : tbNovels) {
			SpiderNovel spiderNovel = mapper.map(tbNovel, SpiderNovel.class);
			if(tbNovel.getImgpath() != null){
				spiderNovel.setImgpath( net.getImageurl() +tbNovel.getImgpath() );
			}
			spiderNovel.setNetUrl(net.getNovelurl().replace("${novelurl}", tbNovel.getId()+""));
			spiderNovels.add(spiderNovel);
		}
		return spiderNovels;
	}

	private static TbNet getTbNetfromMapByID(Long netid) {
		return netMap.get(netid);

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
	 * @param tbNovel
	 * @return
	 */
	public static SpiderNovel tbNovelToSpiderNovel(TbNovel tbNovel ){
		SpiderNovel spiderNovel = mapper.map(tbNovel, SpiderNovel.class);
		//NovelSiteEnum siteenum =  NovelSiteEnum.getEnumById(Long.bitCount( (tbNovel.getNetid())));
		TbNet net = netMap.get(tbNovel.getNetid());
		if(tbNovel.getImgpath() != null){
			spiderNovel.setImgpath(net.getFullurl()+tbNovel.getImgpath());	
		}
		spiderNovel.setNetUrl(net.getNovelurl().replace("${novelurl}", tbNovel.getId()+""));
		return spiderNovel;
	}


	/**
	 * SpiderChapter 转换成 TbChapter
	 * @param spiderChapter
	 * @return
	 */
	public static TbChapter spiderToTbChapter(SpiderChapter spiderChapter){
		TbChapter tbChapter = mapper.map(spiderChapter, TbChapter.class);

		TbNet net = getTbNetfromMap(spiderChapter.getChapterPath());
		
		tbChapter.setNetid(net.getId());
		tbChapter.setChapterPath(null);
		return tbChapter;
	}
	/**
	 * spiderChapters 集合 转换成 TbChapter 集合
	 * @param spiderChapters
	 * @return
	 */
	public static List<TbChapter> spiderToTbChapterList(List<SpiderChapter> spiderChapters){
		List<TbChapter> tbChapters = new ArrayList<TbChapter>();
		if(spiderChapters == null || spiderChapters.size()==0){
			return null;
		}
		TbNet net = getTbNetfromMap(spiderChapters.get(0).getChapterPath());
		for (SpiderChapter spiderChapter : spiderChapters) {
			TbChapter tbChapter = mapper.map(spiderChapter, TbChapter.class);
			tbChapter.setNetid(net.getId());
			tbChapter.setChapterPath(null);
			tbChapters.add(tbChapter);
		}
		return tbChapters;
	}


	/**
	 * TbChapter 转换成 SpiderChapter
	 * @param chapter
	 * @return
	 */
	public static SpiderChapter tbChapterToSpiderChapter(TbChapter chapter ){
		SpiderChapter spiderChapter = mapper.map(chapter, SpiderChapter.class);
		//NovelSiteEnum siteenum =  NovelSiteEnum.getEnumById(Long.bitCount( (tbNovel.getNetid())));
		TbNet net = netMap.get(chapter.getNetid());
		spiderChapter.setChapterPath(net.getChapterinfourl().replace("${novelurl}",chapter.getNovelId()+"")
				.replace("${chapterurl}",chapter.getId()+""));
		return spiderChapter;
	}

	/**
	 *  TbChapter集合 转换成 spiderChapters  集合
	 * @param chapters
	 * @return
	 */
	public static List<SpiderChapter> chapterToSpilderChapterList(List<TbChapter> chapters){
		List<SpiderChapter> spiderChapters = new ArrayList<SpiderChapter>();
		if(chapters == null || chapters.size()==0){
			return null;
		}
		TbNet net = getTbNetfromMap(chapters.get(0).getChapterPath());
		for (TbChapter tbChapter : chapters) {
			SpiderChapter spiderChapter1 = mapper.map(tbChapter, SpiderChapter.class);
			spiderChapter1.setChapterPath(net.getChapterinfourl().replace("${novelurl}",tbChapter.getNovelId()+"")
					.replace("${chapterurl}",tbChapter.getId()+""));
			spiderChapters.add(spiderChapter1);
		}
		return spiderChapters;
	}


}
