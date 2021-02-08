package app.core.store.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import app.core.store.Store;

@Component
@Aspect
public class ClientServiceAspect {

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
