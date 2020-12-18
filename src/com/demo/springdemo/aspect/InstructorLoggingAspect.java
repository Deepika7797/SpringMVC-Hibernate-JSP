package com.demo.springdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InstructorLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
		
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		myLogger.info("....I am executing @Before Add Account Advice Method...");
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method is : "+methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg : args)
		{
			myLogger.info("Objects are: "+tempArg);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint theJoinPoint , Object result)
	{
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("Executing afterReturningFindAccountsAdvice method : "+method);
		myLogger.info("Result : "+result);


	}
	
}
