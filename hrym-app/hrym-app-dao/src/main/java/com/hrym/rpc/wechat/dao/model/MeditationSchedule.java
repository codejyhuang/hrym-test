package com.hrym.rpc.wechat.dao.model;

import java.io.Serializable;

/**
 * Created by hrym13 on 2018/4/12.
 */
public class MeditationSchedule implements Serializable {

    private Integer scheduleId;        //主键ID
    private Integer targetNumber;      //目标数
    private Integer realNumber;        //本活动已上报数
    private Integer createdTime;       //创建共修时间
    private Integer expectTime;       //预期完成目标结束时间
    private String activeTitle;        //共修内容名称
    private Integer groupStatus;       //共修活动身份
    private Integer startTime;         //共修开始时间
    private String activeAuthor;       //组建者
    private String activeHeadUrl;     //活动url
    private  Integer updateTime;
    private Integer refreshTime;      //刷新时间
    private Integer lawTime;          // 法本预习截止时间
    private Integer scheduleType;     //共修内容类型：默认是0表示共修报数内容，1.表示其他共修内容
    //接受
    private Integer userNumber;         //参加活动人数
    private String activeContent;
    private Integer meditationTypeId;    //共修活动类型
    private String percent;                 //百分比
    private long dayDown;                //倒计时
    private String meditationTypeName;      //共修活动类型名称
    private  String scheduleIntro;          //简介
    private String startTimes;
    private String expectTimes;
    private String createdTimes;
    private String updateTimes;
    private Integer status;                 //完成状态；1：完成；2：未完成
    private  Integer myNumber;              //我完成的总遍数
    private Integer myDay;                  //我参加的天数
    private Integer todayNumber;
    private Integer userId;
    private String lawTimes;

    public String getLawTimes() {
        return lawTimes;
    }

    public void setLawTimes(String lawTimes) {
        this.lawTimes = lawTimes;
    }

    public Integer getLawTime() {
        return lawTime;
    }

    public void setLawTime(Integer lawTime) {
        this.lawTime = lawTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTodayNumber() {
        return todayNumber;
    }

    public void setTodayNumber(Integer todayNumber) {
        this.todayNumber = todayNumber;
    }

    public Integer getMyDay() {
        return myDay;
    }

    public void setMyDay(Integer myDay) {
        this.myDay = myDay;
    }

    public Integer getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(Integer myNumber) {
        this.myNumber = myNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(String startTimes) {
        this.startTimes = startTimes;
    }

    public String getExpectTimes() {
        return expectTimes;
    }

    public void setExpectTimes(String expectTimes) {
        this.expectTimes = expectTimes;
    }

    public String getMeditationTypeName() {
        return meditationTypeName;
    }

    public void setMeditationTypeName(String meditationTypeName) {
        this.meditationTypeName = meditationTypeName;
    }

    public String getScheduleIntro() {
        return scheduleIntro;
    }

    public void setScheduleIntro(String scheduleIntro) {
        this.scheduleIntro = scheduleIntro;
    }

    public long getDayDown() {
        return dayDown;
    }

    public void setDayDown(long dayDown) {
        this.dayDown = dayDown;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(Integer targetNumber) {
        this.targetNumber = targetNumber;
    }

    public Integer getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(Integer realNumber) {
        this.realNumber = realNumber;
    }

    public Integer getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Integer expectTime) {
        this.expectTime = expectTime;
    }

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
    }

    public Integer getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public String getActiveAuthor() {
        return activeAuthor;
    }

    public void setActiveAuthor(String activeAuthor) {
        this.activeAuthor = activeAuthor;
    }

    public String getActiveHeadUrl() {
        return activeHeadUrl;
    }

    public void setActiveHeadUrl(String activeHeadUrl) {
        this.activeHeadUrl = activeHeadUrl;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public String getActiveContent() {
        return activeContent;
    }

    public void setActiveContent(String activeContent) {
        this.activeContent = activeContent;
    }

    public Integer getMeditationTypeId() {
        return meditationTypeId;
    }

    public void setMeditationTypeId(Integer meditationTypeId) {
        this.meditationTypeId = meditationTypeId;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedTimes() {
        return createdTimes;
    }

    public void setCreatedTimes(String createdTimes) {
        this.createdTimes = createdTimes;
    }

    public String getUpdateTimes() {
        return updateTimes;
    }

    public void setUpdateTimes(String updateTimes) {
        this.updateTimes = updateTimes;
    }

    public Integer getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(Integer refreshTime) {
        this.refreshTime = refreshTime;
    }

    public Integer getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(Integer scheduleType) {
        this.scheduleType = scheduleType;
    }

    @Override
    public String toString() {
        return "MeditationSchedule{" +
                "scheduleId=" + scheduleId +
                ", targetNumber=" + targetNumber +
                ", realNumber=" + realNumber +
                ", createdTime=" + createdTime +
                ", expectTime=" + expectTime +
                ", activeTitle='" + activeTitle + '\'' +
                ", groupStatus=" + groupStatus +
                ", startTime=" + startTime +
                ", activeAuthor='" + activeAuthor + '\'' +
                ", activeHeadUrl='" + activeHeadUrl + '\'' +
                ", updateTime=" + updateTime +
                ", refreshTime=" + refreshTime +
                ", lawTime=" + lawTime +
                ", scheduleType=" + scheduleType +
                ", userNumber=" + userNumber +
                ", activeContent='" + activeContent + '\'' +
                ", meditationTypeId=" + meditationTypeId +
                ", percent='" + percent + '\'' +
                ", dayDown=" + dayDown +
                ", meditationTypeName='" + meditationTypeName + '\'' +
                ", scheduleIntro='" + scheduleIntro + '\'' +
                ", startTimes='" + startTimes + '\'' +
                ", expectTimes='" + expectTimes + '\'' +
                ", createdTimes='" + createdTimes + '\'' +
                ", updateTimes='" + updateTimes + '\'' +
                ", status=" + status +
                ", myNumber=" + myNumber +
                ", myDay=" + myDay +
                ", todayNumber=" + todayNumber +
                ", userId=" + userId +
                ", lawTimes='" + lawTimes + '\'' +
                '}';
    }
}
