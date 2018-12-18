package com.payease.aspect;

        import org.aspectj.lang.annotation.After;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Before;
        import org.aspectj.lang.annotation.Pointcut;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.stereotype.Component;

/**
 * Created by hrym13 on 2018/4/1.
 */
@Aspect
@Component
public class HttpAspect {

    //日志 为logger.info()提供
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 公共方法
     */
    @Pointcut("execution(public * com.payease.controller.GirlController.*(..))")
    public void log(){
        logger.info("@Pointcut 公共方法：拦截请求aop！");
    }

    /**
     * 方法执行之前
     */
    //@Before("execution(public * com.payease.controller.GirlController.*(..))")
    @Before("log()")
    public void doBefore(){
        logger.info("1。@Before 拦截请求aop！");
    }

    /**
     * 方法执行之后
     */
    @After("log()")
    public void doAfter(){
        logger.info("2。@After 拦截请求aop！");
    }
}
