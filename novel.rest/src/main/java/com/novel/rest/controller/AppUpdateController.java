package com.novel.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novel.common.pojo.TbVersion;
import com.novel.rest.service.TbVersionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "小说app版本管理")
@RequestMapping("/version")
public class AppUpdateController {

	@Autowired
	private TbVersionService tbVersionService;

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "获取最新app版本信息", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TbVersion findNewAppVersion() {

		TbVersion versionInfo = tbVersionService.findNewTbVersion();
		return versionInfo;

	}

}
