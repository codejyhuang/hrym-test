package com.payease.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by hrym13 on 2018/10/22.
 */
@Configuration
@Slf4j
public class JedisPoolFactory {
    
    // 自动注入redis配置文件
    @Autowired
    private RedisProperties redis;
    
    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(redis.getJedis().getPool().getMaxIdle());
        config.setMaxWaitMillis(redis.getJedis().getPool().getMaxWait().toMillis());
        config.setMaxTotal(redis.getJedis().getPool().getMaxActive());
        JedisPool jedisPool = new JedisPool(config, redis.getHost(), redis.getPort(), 5000, null);
        
        log.info("JedisPool注入成功！");
        log.info("redis地址：" + redis.getHost() + ":" + redis.getPort());
        return jedisPool;
    }
    
}

