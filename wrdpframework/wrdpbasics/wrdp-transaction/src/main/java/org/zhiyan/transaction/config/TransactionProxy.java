package org.zhiyan.transaction.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@EnableAspectJAutoProxy
@Aspect
@Component
public class TransactionProxy {

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Pointcut("execution(public * *..*BO.*(..))")
	public void recordLog() {
		this.printLog("recordLog");
	}

	@Around("recordLog()")
	public Object around(final ProceedingJoinPoint pjp) throws Throwable {
		this.printLog("事务开启");
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		Object result = transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					return pjp.proceed();
				} catch (Throwable e) {
					throw new RuntimeException(e);
				}
			}
		});
		return result;
	}

	private void printLog(String str) {
		System.out.println(str);
	}
}