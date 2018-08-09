package com.novel.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novel.common.util.EUTreeNode;
import com.novel.rest.service.TbTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "小说类型信息获取api", description = "获取小说类型")
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TbTypeService tbTypeService;

	@ApiOperation(httpMethod = "GET", value = "查询小说类型信息列表", notes = "查询小说类型信息列表")
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<EUTreeNode> gettbTypeList() {
		// TbNovel tbNovel = new TbNovel();
		// tbNovel.setTitle(novel.get);
		List<EUTreeNode> result = tbTypeService.getTbTypeList();
		return result;
	}

}
