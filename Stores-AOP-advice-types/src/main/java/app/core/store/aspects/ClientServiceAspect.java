package app.core.store.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import app.core.store.Store;

@Component
@Aspect
public class ClientServiceAspect {

	private int salesCounter;

	public int getSalesCounter() {
		return salesCounter;
	}

	// 2. after returning
	@AfterReturning(pointcut = "execution(String buy(String))", returning = "msg")
	public void afterBuySuccess(JoinPoint jp, String msg) {
		System.out.println(">>> " + msg);
		salesCounter++;
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

		System.out.println(">>> product returned: " + product + " to store: " + store.getClass().getSimpleName());

	}
}
