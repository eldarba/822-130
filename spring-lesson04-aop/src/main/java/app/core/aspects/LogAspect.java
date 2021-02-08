package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static int getCounter;

	@Before("execution(* get*(..))")
	public void beforeGet() {
		getCounter++;
	}

	public static int getGetCounter() {
		return getCounter;
	}

	@Before("execution(public void add*(..))")
	public void beforeAddAdvice(JoinPoint jp) {
		System.out.println(">>> LogAspect: execute @Before advice on add methods: " + jp);
		Object target = jp.getTarget();
		System.out.println("target: " + target.getClass().getSimpleName());
	}

	@Before("execution(*  app.core.dao.coupon.*.*(..))")
	public void beforePackageAdvice() {
		System.out.println("--- LogAspect: execute @Before advice on coupon package");
	}

}
