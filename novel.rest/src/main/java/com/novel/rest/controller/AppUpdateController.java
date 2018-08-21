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
		 
		// 
	    mCheckUpdateInfo.setisForceUpdate(1);//设置是否强制更新,该方法的参数只要和服务端商定好什么数字代表强制更新即可
		mCheckUpdateInfo.setnewAppReleaseTime("2018-06-20 12:37");//软件发布时间
		mCheckUpdateInfo.setnewAppSize(4.3f);//单位为M
		mCheckUpdateInfo.setnewAppUrl("https://novel01-1252454126.cos.ap-beijing.myqcloud.com/novel/dbiccamera_v2.1_3.apk");
		mCheckUpdateInfo.setnewAppVersionCode(20);//新app的VersionCode
		mCheckUpdateInfo.setnewAppVersionName("2.0.2");
		mCheckUpdateInfo.setnewAppUpdateDesc("1,优化下载逻辑\n2,修复一些bug\n3,完全实现强制更新与非强制更新逻辑\n4,非强制更新状态下进行下载,默认在后台进行下载\n5,当下载成功时,会在通知栏显示一个通知,点击该通知,进入安装应用界面\n6,当下载失败时,会在通知栏显示一个通知,点击该通知,会重新下载该应用\n7,当下载中,会在通知栏显示实时下载进度,但前提要dialog.setShowProgress(true).");

		
		return mCheckUpdateInfo;
		
	}

}
