package com.payease.vo;

import java.io.Serializable;

/**
 * Created by hrym13 on 2018/4/4.
 */
public class UserVo implements Serializable {

    private Integer userId;
    private Integer createdTime;
    private String userName;
    private String passWord;
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getCreatedTime() {
        return createdTime;
    }
    
    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}
