package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class StatisticsAspectDeclarations {

	private static int getCounter;
	private static int setCounter;

	// this is a pointcut declaration
	@Pointcut("execution(* get*(..))")
	public void getters() {
	}

	@Pointcut("execution(* set*(..))")
	public void setters() {
	}

	@Before("getters()")
	public void beforeGet() {
		System.out.println(">>> stats");
		getCounter++;
	}

	@Before("setters()")
	public void beforeSet() {
		System.out.println(">>> stats");
		setCounter++;
	}

	public static int getGetCounter() {
		return getCounter;
	}

	public static int getSetCounter() {
		return setCounter;
	}

}
