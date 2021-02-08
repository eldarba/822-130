package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Component
@Aspect
public class LogAspectX {

	private static int getCounter;
	private static int setCounter;

	@Before("execution(* get*(..))")
	public void beforeGet() {
		getCounter++;
	}

	@Before("execution(* set*(..))")
	public void beforeSet() {
		setCounter++;
	}

	@Before("execution(* get*(..)) || execution(* set*(..))")
	public void beforeGetOrSet(JoinPoint jp) {
		System.out.println("<><><> (get or set: )" + jp);
	}

	public static int getGetCounter() {
		return getCounter;
	}

	public static int getSetCounter() {
		return setCounter;
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
