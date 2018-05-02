package com.novel.manage.scheduler;


import java.sql.Time;

/**
 * Created by Admin on 2017/11/10.
 */

public class UtiQuartzConfig {
    private long id;
    private String jobCode;
    private String jobDescription;
    private String userCode;
    private String second;
    private String minute;
    private String hour;
    private String day;
    private String month;
    private String week;
    private String year;
    private String cronExpression;
    private String targetObject;
    private String targetMethod;
    private String conCurrent;
    private String validStatus;
    private long version;
    private Time insertTimeForHis;
    private Time operateTimeForHis;

    /*
    * 属性id的getter方法
    */

    public long getId() {
        return id;
    }

    /*
    * 属性id的setter方法
    */
    public void setId(long id) {
        this.id = id;
    }

    /*
    * 属性jobCode的getter方法
    */

    public String getJobCode() {
        return jobCode;
    }

    /*
    * 属性jobCode的setter方法
    */
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    /*
    * 属性jobDescription的getter方法
    */

    public String getJobDescription() {
        return jobDescription;
    }

    /*
    * 属性jobDescription的setter方法
    */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /*
    * 属性userCode的getter方法
    */

    public String getUserCode() {
        return userCode;
    }

    /*
    * 属性userCode的setter方法
    */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /*
    * 属性second的getter方法
    */

    public String getSecond() {
        return second;
    }

    /*
    * 属性second的setter方法
    */
    public void setSecond(String second) {
        this.second = second;
    }

    /*
    * 属性minute的getter方法
    */

    public String getMinute() {
        return minute;
    }

    /*
    * 属性minute的setter方法
    */
    public void setMinute(String minute) {
        this.minute = minute;
    }

    /*
    * 属性hour的getter方法
    */

    public String getHour() {
        return hour;
    }

    /*
    * 属性hour的setter方法
    */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /*
    * 属性day的getter方法
    */

    public String getDay() {
        return day;
    }

    /*
    * 属性day的setter方法
    */
    public void setDay(String day) {
        this.day = day;
    }

    /*
    * 属性month的getter方法
    */

    public String getMonth() {
        return month;
    }

    /*
    * 属性month的setter方法
    */
    public void setMonth(String month) {
        this.month = month;
    }

    /*
    * 属性week的getter方法
    */

    public String getWeek() {
        return week;
    }

    /*
    * 属性week的setter方法
    */
    public void setWeek(String week) {
        this.week = week;
    }

    /*
    * 属性year的getter方法
    */

    public String getYear() {
        return year;
    }

    /*
    * 属性year的setter方法
    */
    public void setYear(String year) {
        this.year = year;
    }

    /*
    * 属性cronExpression的getter方法
    */

    public String getCronExpression() {
        return cronExpression;
    }

    /*
    * 属性cronExpression的setter方法
    */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /*
    * 属性targetObject的getter方法
    */

    public String getTargetObject() {
        return targetObject;
    }

    /*
    * 属性targetObject的setter方法
    */
    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    /*
    * 属性targetMethod的getter方法
    */

    public String getTargetMethod() {
        return targetMethod;
    }

    /*
    * 属性targetMethod的setter方法
    */
    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    /*
    * 属性conCurrent的getter方法
    */

    public String getConCurrent() {
        return conCurrent;
    }

    /*
    * 属性conCurrent的setter方法
    */
    public void setConCurrent(String conCurrent) {
        this.conCurrent = conCurrent;
    }

    /*
    * 属性validStatus的getter方法
    */

    public String getValidStatus() {
        return validStatus;
    }

    /*
    * 属性validStatus的setter方法
    */
    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    /*
    * 属性version的getter方法
    */

    public long getVersion() {
        return version;
    }

    /*
    * 属性version的setter方法
    */
    public void setVersion(long version) {
        this.version = version;
    }

    /*
    * 属性insertTimeForHis的getter方法
    */

    public Time getInsertTimeForHis() {
        return insertTimeForHis;
    }

    /*
    * 属性insertTimeForHis的setter方法
    */
    public void setInsertTimeForHis(Time insertTimeForHis) {
        this.insertTimeForHis = insertTimeForHis;
    }

    /*
    * 属性operateTimeForHis的getter方法
    */

    public Time getOperateTimeForHis() {
        return operateTimeForHis;
    }

    /*
    * 属性operateTimeForHis的setter方法
    */
    public void setOperateTimeForHis(Time operateTimeForHis) {
        this.operateTimeForHis = operateTimeForHis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtiQuartzConfig that = (UtiQuartzConfig) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (jobCode != null ? !jobCode.equals(that.jobCode) : that.jobCode != null) return false;
        if (jobDescription != null ? !jobDescription.equals(that.jobDescription) : that.jobDescription != null)
            return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (second != null ? !second.equals(that.second) : that.second != null) return false;
        if (minute != null ? !minute.equals(that.minute) : that.minute != null) return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        if (week != null ? !week.equals(that.week) : that.week != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (cronExpression != null ? !cronExpression.equals(that.cronExpression) : that.cronExpression != null)
            return false;
        if (targetObject != null ? !targetObject.equals(that.targetObject) : that.targetObject != null) return false;
        if (targetMethod != null ? !targetMethod.equals(that.targetMethod) : that.targetMethod != null) return false;
        if (conCurrent != null ? !conCurrent.equals(that.conCurrent) : that.conCurrent != null) return false;
        if (validStatus != null ? !validStatus.equals(that.validStatus) : that.validStatus != null) return false;
        if (insertTimeForHis != null ? !insertTimeForHis.equals(that.insertTimeForHis) : that.insertTimeForHis != null)
            return false;
        if (operateTimeForHis != null ? !operateTimeForHis.equals(that.operateTimeForHis) : that.operateTimeForHis != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (jobCode != null ? jobCode.hashCode() : 0);
        result = 31 * result + (jobDescription != null ? jobDescription.hashCode() : 0);
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (second != null ? second.hashCode() : 0);
        result = 31 * result + (minute != null ? minute.hashCode() : 0);
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (week != null ? week.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (cronExpression != null ? cronExpression.hashCode() : 0);
        result = 31 * result + (targetObject != null ? targetObject.hashCode() : 0);
        result = 31 * result + (targetMethod != null ? targetMethod.hashCode() : 0);
        result = 31 * result + (conCurrent != null ? conCurrent.hashCode() : 0);
        result = 31 * result + (validStatus != null ? validStatus.hashCode() : 0);
        result = 31 * result + (int) (version ^ (version >>> 32));
        result = 31 * result + (insertTimeForHis != null ? insertTimeForHis.hashCode() : 0);
        result = 31 * result + (operateTimeForHis != null ? operateTimeForHis.hashCode() : 0);
        return result;
    }
}
