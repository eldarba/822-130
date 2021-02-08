package app.core.aspects;

import org.aspectj.lang.JoinPoint;
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
	public void beforeSet(JoinPoint jp) {
		System.out.println("============== setter stats");
		System.out.println(jp);
		System.out.println(jp.getSignature());
		Object target = jp.getTarget();
		System.out.println("target object: " + target);
		System.out.println("method arguments");
		Object[] args = jp.getArgs();
		if (args.length == 0) {
			System.out.println("this method has no parameters");
		}
		for (Object arg : args) {
			System.out.println(arg.getClass().getSimpleName() + ": " + arg);
		}
		System.out.println("============== ============");
		setCounter++;
	}

	public static int getGetCounter() {
		return getCounter;
	}

	public static int getSetCounter() {
		return setCounter;
	}

}
