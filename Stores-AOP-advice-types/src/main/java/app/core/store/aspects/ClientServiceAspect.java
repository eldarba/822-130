package app.core.store.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import app.core.store.Store;

@Component
@Aspect
public class ClientServiceAspect {

	private int salesSuccessCounter;
	private int salesFailCounter;
	private int salesAttemptCounter;

	// 5. around advice
	@Around("execution(* getProducts(..))")
	public Object aroundGetProducts(ProceedingJoinPoint jp) throws Throwable {
		System.out.println(">>>@Around before: ");
		if (Math.random() < 0.5) {
			return null;
		}
		Object result = jp.proceed(); // proxy invokes the business method
		System.out.println(result);
		System.out.println(">>>@Around after: ");
		return result;
	}

	// 4. after (finally) advice
	@After("execution(String buy(String))")
	public void afterBuyAttempt(JoinPoint jp) {
		System.out.println(">>>@After: " + jp);
		salesAttemptCounter++;
	}

	// 3. after returning advice
	@AfterThrowing(pointcut = "execution(String buy(String))", throwing = "e")
	public void afterBuyFail(JoinPoint jp, Throwable e) {
		System.out.println(">>>@AfterThrowing: " + e.getMessage());
		salesFailCounter++;
	}

	// 2. after returning advice
	@AfterReturning(pointcut = "execution(String buy(String))", returning = "msg")
	public void afterBuySuccess(JoinPoint jp, String msg) {
		System.out.println(">>>@AfterReturning: " + msg);
		salesSuccessCounter++;
	}

	// 1. before advice
	@Before("execution(* returnProduct(..))")
	public void beforeProductReturn(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String product = "unknown";
		for (Object arg : args) {
			if (arg instanceof String) {
				product = (String) arg;
			}
		}

		Store store = (Store) jp.getTarget();
		store.getProducts();

		System.out
				.println(">>>@Before: product returned: " + product + " to store: " + store.getClass().getSimpleName());

	}

	public int getSalesCounter() {
		return salesSuccessCounter;
	}

	public int getSalesFailCounter() {
		return salesFailCounter;
	}

	public int getSalesAttemptCounter() {
		return salesAttemptCounter;
	}
}
