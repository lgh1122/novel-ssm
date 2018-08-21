package com.novel.rest.pojo;

import java.io.Serializable;

public class CheckUpdateInfo implements Serializable {
	    private String appName;
	    private float newAppSize;
	    private int newAppVersionCode;
	    private String newAppVersionName;
	    private String newAppUpdateDesc;
	    private String newAppReleaseTime;
	    private String newAppUrl;
	    private int isForceUpdate;

	    private int isUseNewPage;
	    public CheckUpdateInfo() {
	    }

	    public CheckUpdateInfo(String appName, float newAppSize, int newAppVersionCode, String newAppVersionName, String newAppUpdateDesc, String newAppReleaseTime, String newAppUrl, int isForceUpdate) {
	        this.appName = appName;
	        this.newAppSize = newAppSize;
	        this.newAppVersionCode = newAppVersionCode;
	        this.newAppVersionName = newAppVersionName;
	        this.newAppUpdateDesc = newAppUpdateDesc;
	        this.newAppReleaseTime = newAppReleaseTime;
	        this.newAppUrl = newAppUrl;
	        this.isForceUpdate = isForceUpdate;
	    }

		public String getAppName() {
			return appName;
		}

	public int getisUseNewPage() {
		return isUseNewPage;
	}

	public void setisUseNewPage(int isUseNewPage) {
		this.isUseNewPage = isUseNewPage;
	}

	public void setAppName(String appName) {
			this.appName = appName;
		}

		public float getnewAppSize() {
			return newAppSize;
		}

		public void setnewAppSize(float newAppSize) {
			this.newAppSize = newAppSize;
		}

		public int getnewAppVersionCode() {
			return newAppVersionCode;
		}

		public void setnewAppVersionCode(int newAppVersionCode) {
			this.newAppVersionCode = newAppVersionCode;
		}

		public String getnewAppVersionName() {
			return newAppVersionName;
		}

		public void setnewAppVersionName(String newAppVersionName) {
			this.newAppVersionName = newAppVersionName;
		}

		public String getnewAppUpdateDesc() {
			return newAppUpdateDesc;
		}

		public void setnewAppUpdateDesc(String newAppUpdateDesc) {
			this.newAppUpdateDesc = newAppUpdateDesc;
		}

		public String getnewAppReleaseTime() {
			return newAppReleaseTime;
		}

		public void setnewAppReleaseTime(String newAppReleaseTime) {
			this.newAppReleaseTime = newAppReleaseTime;
		}

		public String getnewAppUrl() {
			return newAppUrl;
		}

		public void setnewAppUrl(String newAppUrl) {
			this.newAppUrl = newAppUrl;
		}

		public int getisForceUpdate() {
			return isForceUpdate;
		}

		public void setisForceUpdate(int isForceUpdate) {
			this.isForceUpdate = isForceUpdate;
		}
	    
	    
	

}
