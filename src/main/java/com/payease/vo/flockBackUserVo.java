package com.payease.vo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hrym13 on 2018/12/2.
 */
@Setter
@Getter
public class flockBackUserVo implements Serializable {
    
    private Integer id;
    private Integer flockId;
    private Integer itemId;
    private Integer contentId;             // '版本id',
    private Integer itemType;            //'功课类型\n0:平台\n1:自建\n2:经书',
    private Integer type;                 //'0:群回向\n1:特别回向',
    private Integer time;                  // '回向时间',
    private Integer flag;              //'是否可修改\n0:可以修改\n1:不可以',
    private String info;                  //'回向文',
    private Integer uuid;                 //'0:系统统一回向\n其他：uuid',
    private String name;                 // 群名称
    private String avatarUrl;           //群头像
    private String nickname;            //昵称
    private String avatar;              // 群主头像
    private String versionName;         // 功课名称
    
//    private String descJson;
    private List< flockBackUserVo> descJson;
    
    
    private Integer recordId;
    private String ymd;
    
}
