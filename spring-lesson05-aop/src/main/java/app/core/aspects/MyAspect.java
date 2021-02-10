package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	// method level annotation
	@Pointcut("@annotation(app.core.aspects.annotations.MyAOPAnnotation)")
	public void annotatedMethod() {
	}

	// class level annotation
	@Pointcut("@target(app.core.aspects.annotations.MyAOPAnnotation)")
	public void annotatedClass() {
	}

	@Before("annotatedMethod()")
	public void beforeDivWithAnnotation(JoinPoint jp) {
		System.out.println(">>> *** @Before " + jp.getSignature().getName() + " annotation");
		// how to get annotation element values from method
//		try {
//			MyAOPAnnotation annotation = jp.getTarget().getClass().getMethod("div", int.class, int.class)
//					.getDeclaredAnnotation(MyAOPAnnotation.class);
//			System.out.println("condtion: " + annotation.condition());
//			System.out.println("key: " + annotation.key());
//			System.out.println("value: " + annotation.value());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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

	@Around("div()")
	public Object aroundDiv(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">>> @Around-before " + pjp.getSignature().getName());
		try {
			Object res = pjp.proceed(); // invoke business method
			System.out.println(">>> @Around-after-return " + pjp.getSignature().getName() + ": " + res);
			return res;
		} catch (Exception e) {
			System.out.println(">>> @Around-after-throw " + pjp.getSignature().getName() + ": " + e);
			throw e; // propagate exception to client
//			return "infinity"; // handle exception in the aspect and return some result
		}
	}

}
