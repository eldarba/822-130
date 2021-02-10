package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(String div(int, int))")
	public void div() {
	}

	@Before("div()")
	public void beforeDiv(JoinPoint jp) {
		System.out.println(">>> @Before " + jp.getSignature().getName());
	}

	@After("div()")
	public void afterDiv(JoinPoint jp) {
		System.out.println(">>> @After " + jp.getSignature().getName());
	}

	@AfterReturning(pointcut = "div()", returning = "result")
	public void afterDivReturns(JoinPoint jp, String result) {
		System.out.println(">>> @AfterReturning " + jp.getSignature().getName() + " : " + result);
	}

	@AfterThrowing(pointcut = "div()", throwing = "e")
	public void afterDivThrows(JoinPoint jp, Throwable e) {
		System.out.println(">>> @AfterThrowing " + jp.getSignature().getName() + " : " + e);
	}

}
