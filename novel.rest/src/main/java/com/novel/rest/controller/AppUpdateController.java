package com.novel.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novel.rest.pojo.CheckUpdateInfo;

@Controller
@RequestMapping("/version")
public class AppUpdateController {
	
	@RequestMapping(value = "/find")
    @ResponseBody
	public CheckUpdateInfo findNewAppVersion() {
		CheckUpdateInfo mCheckUpdateInfo = new CheckUpdateInfo();
		mCheckUpdateInfo.setAppName("都邦水印相机");
		 
		// 是多少
	    mCheckUpdateInfo.setIsForceUpdate(1);//设置是否强制更新,该方法的参数只要和服务端商定好什么数字代表强制更新即可
		mCheckUpdateInfo.setNewAppReleaseTime("2018-06-20 12:37");//软件发布时间
		mCheckUpdateInfo.setNewAppSize(4.3f);//单位为M
		mCheckUpdateInfo.setNewAppUrl("https://novel01-1252454126.cos.ap-beijing.myqcloud.com/novel/dbiccamera_v2.1_3.apk");
		mCheckUpdateInfo.setNewAppVersionCode(20);//新app的VersionCode
		mCheckUpdateInfo.setNewAppVersionName("2.0.2");
		mCheckUpdateInfo.setNewAppUpdateDesc("1,优化下载逻辑\n2,修复一些bug\n3,完全实现强制更新与非强制更新逻辑\n4,非强制更新状态下进行下载,默认在后台进行下载\n5,当下载成功时,会在通知栏显示一个通知,点击该通知,进入安装应用界面\n6,当下载失败时,会在通知栏显示一个通知,点击该通知,会重新下载该应用.");
mCheckUpdateInfo.setIsUsePreDialog(1);
		
		return mCheckUpdateInfo;
		
	}

}
