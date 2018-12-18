package com.payease;

import com.payease.utils.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.SortingParams;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by hrym13 on 2018/10/22.
 */
public class RedisTest extends GirlApplicationTests {
    
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private RedisProperties redis;
    
    @Test
    public void testString() {
        //操作String类型的数据
        ValueOperations<String, String> valueStr = redisTemplate.opsForValue();
        //存储一条数据
        valueStr.set("goodsProdu", "长安");
        //获取一条数据并输出
        String goodsName = valueStr.get("goodsProdu");
        System.out.println(goodsName);
        //存储多条数据
        Map<String, String> map = new HashMap<>();
        map.put("goodsName", "福特汽车");
        map.put("goodsPrice", "88888");
        map.put("goodsId", "88");
        
        valueStr.multiSet(map);
        //获取多条数据
        System.out.println("========================================");
        List<String> list = new ArrayList<>();
        list.add("goodsName");
        list.add("goodsPrice");
        list.add("goodsId");
        list.add("goodsProdu");
        
        List<String> listKeys = valueStr.multiGet(list);
        for (String key : listKeys) {
            System.out.println(key);
        }
        
        
    }
    
    @Test
    public void testRedisKey() {
        System.out.println("port" + redis.getHost() + redis.getPort());
//        redisTemplate.opsForValue().set("keyString1","key11111");
//        redisTemplate.opsForValue().getAndSet("keyString2","ssswwww");
        Collection<String> list = new ArrayList<String>();
        list.add("keyString1");
        list.add("keyString");
        list.add("keyString2");
        List list1 = redisTemplate.opsForValue().multiGet(list);
        for (Object li : list1) {
            System.out.println("li" + li);
        }
        list1.forEach((Consumer) list1);
    }
    
    /**
     * redis添加string缓存
     */
    @Test
    public void testRedis() {
//        redisTemplate.opsForValue().set("hello", "luzhihe");
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }
    
    /**
     * redis删除缓存
     */
    @Test
    public void testDelRedis() {
        System.out.println(redisTemplate.opsForValue().get("hello"));
        System.out.println("+++++++++++++++");
        redisTemplate.delete("hello");
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }
    
    @Test
    public void testKey() {
        
        Jedis jedis = new Jedis();
        
        Set<String> getKey = jedis.keys("*");
        System.out.println("=====key功能展示====");
//        System.out.println("清除数据"+jedis.flushDB());
        System.out.println("新增键值对" + jedis.mset("ss", "sss", "ww", "你好吗", "hh", "😄"));
//        System.out.println("获取所有键值对"+getKey);
//        System.out.println("删除目标键值对键值对"+jedis.del("ss"));
//        System.out.println("获取所有键值对"+getKey);
//        System.out.println("设置键值对过期时间i秒"+jedis.expire("ss",3000));
        System.out.println("获取键值对剩余时间i秒" + jedis.append("ss", "22"));
        System.out.println("添加一个list:" + jedis.lpush("list", "lista", "listb", "listc", "listd"));
        SortingParams sortingParams = new SortingParams();
        System.out.println("list的排序按字母a-z：" + jedis.sort("list", sortingParams.alpha()));
        System.out.println("list的排序升序：" + jedis.sort("list", sortingParams.asc()));
        System.out.println("list的排序降序：" + jedis.sort("list", sortingParams.desc()));
        
    }
    
}
