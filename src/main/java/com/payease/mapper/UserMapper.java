package com.payease.mapper;

import com.payease.entity.User;
import com.payease.vo.UserVo;
import com.payease.vo.flockBackUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hrym13 on 2018/4/4.
 */
@Repository
@Mapper
public interface UserMapper {


    @Select("SELECT id,time,user_name as userName,pass_word FROM user")
    List <User> findAllUser();

    @Select("SELECT id,time,user_name,pass_word FROM user WHERE user_name = #{userName}")
    UserVo findUserByUserName(UserVo userVo);
    
    @Select("select * from t_dedication_verses where type = #{type} and uuid =#{uuid}")
    List<flockBackUserVo> findFlockBackUserListByType(@Param("type") Integer type,@Param("uuid") Integer uuid);
    

}
