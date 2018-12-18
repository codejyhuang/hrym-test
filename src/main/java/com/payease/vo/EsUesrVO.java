package com.payease.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Created by hrym13 on 2018/11/3.
 */
@Getter
@Setter
@Document(indexName = "item-book", type = "testUser", shards = 5, replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class EsUesrVO implements Serializable {
    
    private static final long serialVersionUID = 551589397625941750L;
    
    @Id
    private int uuid;
    private String socialUid;
    private String name;
    private String nickName;
    private String mobile;
    private String email;
    private String passWord;
    private Integer sex;
    private Integer source;
    private String avatar;
    private Integer createdTime;
    private Integer updatedTime;
    private Integer status;
    
    public EsUesrVO() {
    }
    
    public EsUesrVO(int uuid, String socialUid, String name, String nickName,
                    String mobile,String email) {
        this.uuid = uuid;
        this.socialUid = socialUid;
        this.name = name;
        this.nickName = nickName;
        this.mobile = mobile;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "EsUesrVO{" +
                "uuid=" + uuid +
                ", socialUid='" + socialUid + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", source=" + source +
                ", avatar='" + avatar + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", status=" + status +
                '}';
    }
}
