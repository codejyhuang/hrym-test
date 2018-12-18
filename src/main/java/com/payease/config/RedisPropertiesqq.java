package com.payease.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.List;

/**
 * Created by hrym13 on 2018/10/23.
 */
@ConfigurationProperties(prefix = "spring.redis")
public class RedisPropertiesqq {
    
    /**
     * Database index used by the connection factory.
     */
    private int database = 0;
    
    /**
     * Connection URL. Overrides host, port, and password. User is ignored. Example:
     * redis://user:password@example.com:6379
     */
    private String url;
    
    /**
     * Redis server host.
     */
    private String host = "192.168.1.171";
    
    /**
     * Login password of the redis server.
     */
    private String password;
    
    /**
     * Redis server port.
     */
    private int port = 6379;
    
    /**
     * Whether to enable SSL support.
     */
    private boolean ssl;
    
    /**
     * Connection timeout.
     */
    private Duration timeout;
    
    private Sentinel sentinel;
    
    private Cluster cluster;
    
    private final Jedis jedis = new Jedis();
    
    private final Lettuce lettuce = new Lettuce();
    
    /**
     *此处省略了所有的get set方法
     */
    
    /**
     * Pool properties.（连接池的配置信息）
     */
    public static class Pool {
        
        /**
         * Maximum number of "idle" connections in the pool. Use a negative value to
         * indicate an unlimited number of idle connections.
         */
        private int maxIdle = 8;
        
        /**
         * Target for the minimum number of idle connections to maintain in the pool. This
         * setting only has an effect if it is positive.
         */
        private int minIdle = 0;
        
        /**
         * Maximum number of connections that can be allocated by the pool at a given
         * time. Use a negative value for no limit.
         */
        private int maxActive = 8;
        
        /**
         * Maximum amount of time a connection allocation should block before throwing an
         * exception when the pool is exhausted. Use a negative value to block
         * indefinitely.
         */
        private Duration maxWait = Duration.ofMillis(-1);
        /**
         *省略了关于连接池属性信息的get set方法
         */
    }
    
    /**
     * Cluster properties.（集群配置信息）
     */
    public static class Cluster {
        
        /**
         * Comma-separated list of "host:port" pairs to bootstrap from. This represents an
         * "initial" list of cluster nodes and is required to have at least one entry.
         */
        private List<String> nodes;
        
        /**
         * Maximum number of redirects to follow when executing commands across the
         * cluster.
         */
        private Integer maxRedirects;
        /**
         *省略了关于集群配置信息的get set方法
         */
        
    }
    
    /**
     * Redis sentinel properties.（哨兵属性信息）
     */
    public static class Sentinel {
        
        /**
         * Name of the Redis server.
         */
        private String master;
        
        /**
         * Comma-separated list of "host:port" pairs.
         */
        private List<String> nodes;
        /**
         *省略了关于哨兵属性信息的get set方法
         */
        
    }
    
    /**
     * Jedis client properties.（redis的客户端jedis）
     */
    public static class Jedis {
        
        /**
         * Jedis pool configuration.
         */
        private Pool pool;
        /**
         *省略了关于jedis属性信息的get set方法
         */
        
    }
    
    /**
     * Lettuce client properties.
     */
    public static class Lettuce {
        
        /**
         * Shutdown timeout.
         */
        private Duration shutdownTimeout = Duration.ofMillis(100);
        
        /**
         * Lettuce pool configuration.
         */
        private Pool pool;
    }
}
