package com.payease.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.payease.entity.User;
import com.payease.mapper.UserMapper;
import com.payease.respository.UserInfoRepository;
import com.payease.service.UserService;
import com.payease.utils.RedisUtil;
import com.payease.vo.EsUesrVO;
import com.payease.vo.UserVo;
import com.payease.vo.flockBackUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hrym13 on 2018/4/4.
 */
@Service
public class UserServiceImpl implements UserService {
    
    
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;
    // 自动注入redis配置文件
    @Autowired
    private RedisProperties redis;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private ElasticsearchTemplate template;
    
    
    @Override
    public List findAllUser() {
        
        List<User> userList = userMapper.findAllUser();
//        Jedis jedis = new Jedis(redis.getHost(), redis.getPort());
//        System.out.println(redis.getHost() + redis.getPort());
//        for (UserVo u : userList) {
//            jedis.lpush("lista",u.getUserName());
//            u.setUserName(u.getUserName());
//        }
//        jedis.set("users", JSON.toJSONString(userList));
        System.out.println(userList);
        
        return userList;
    }
    
    /**
     * 登录
     *
     * @param userVo
     * @return
     */
    @Override
    public UserVo findUserByUserName(UserVo userVo) {
        
        if (userVo.getUserName() == null || userVo.getPassWord() == null) {
            return null;
        } else {
            UserVo user = userMapper.findUserByUserName(userVo);
            if (user != null || user.getPassWord() == userVo.getPassWord()) {
                return user;
            } else {
                return null;
            }
        }
    }
    
    /**
     * es里查找所有用户信息
     * @return
     */
    @Override
    public Iterable<EsUesrVO> findAllEsUser() {
        
        Iterable<EsUesrVO> list =  userInfoRepository.findAll();
        return list;
    }
    public Iterable<EsUesrVO> testSearchUserById(EsUesrVO esUesrVO){
    
        Iterable<EsUesrVO> list = userInfoRepository.search((SearchQuery) esUesrVO);
        return list;
    }
    
    @Override
    public Map<String, Object> findFlockBackUserListByType(Integer type, Integer uuid) {
        
        Map<String,Object>maps = new HashMap<>();
        List<flockBackUserVo> list = userMapper.findFlockBackUserListByType(0,24);
        for (flockBackUserVo ss: list){
            for ( flockBackUserVo sss : ss.getDescJson()){
    
                System.out.println(sss);
            }
            System.out.println(ss);
        }
        System.out.println(list);
        maps.put("list",list);
        
        return maps;
    }
    
    
    public static void main(String[] args) {
        int [] x=new int[10];
        System.out.println(x.length );
    }
}
