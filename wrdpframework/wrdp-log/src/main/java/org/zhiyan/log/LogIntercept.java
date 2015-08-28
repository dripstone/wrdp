package org.zhiyan.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogIntercept {

    @Pointcut("execution(public * org.zhiyan..*.create(..))")
    public void recordLog() {
        this.printLog("recordLog");
    }

    @Before("recordLog()")
    public void before() {
        this.printLog("已经记录下操作日志@Before 方法执行前");
    }

    @Around("recordLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        this.printLog("已经记录下操作日志@Around 方法执行前");
        pjp.getArgs();
        result = pjp.proceed();
        this.printLog("已经记录下操作日志@Around 方法执行后");
        return result;
    }

    @After("recordLog()")
    public void after() {
        this.printLog("已经记录下操作日志@After 方法执行后");
    }

    private void printLog(String str) {
        System.out.println(str);
    }
}