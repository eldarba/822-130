package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class StatistaicsAspect {

	private int counter;

	@Before("getMethods()")
	public void addOrDeleteOrLogin(JoinPoint jp) {
		counter++;
	}

	@Pointcut("execution(* app.core.*.get*(..))")
	public void getMethods() {
	}

	public int getNumberOfGetCalls() {
		return counter;
	}

}
