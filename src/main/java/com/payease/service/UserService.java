package com.payease.service;

import com.payease.vo.EsUesrVO;
import com.payease.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * Created by hrym13 on 2018/4/4.
 */
public interface UserService {

    List findAllUser();
    UserVo findUserByUserName(UserVo userVo);
    
    Iterable<EsUesrVO> findAllEsUser();
    
    Iterable<EsUesrVO> testSearchUserById(EsUesrVO esUesrVO);
    
    Map<String,Object> findFlockBackUserListByType(Integer type, Integer uuid);
}
