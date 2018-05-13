package com.novel.rest.controller;

import java.util.List;

import com.novel.rest.service.TbTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novel.common.util.EUTreeNode;


@Controller
@RequestMapping("/type")
public class TypeController {
	 
	@Autowired
	private TbTypeService tbTypeService;
	
		
	 
	 
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<EUTreeNode> gettbTypeList() {
		//TbNovel tbNovel = new TbNovel();
		//tbNovel.setTitle(novel.get);
		List<EUTreeNode> result = tbTypeService.getTbTypeList();
		return result;
	}
	
	 
	
}
