package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LogAspectDeclarations {

	// this is a pointcut declaration
	@Pointcut("execution(* get*(..))")
	public void getters() {
	}

	@Pointcut("execution(* set*(..))")
	public void setters() {
	}

	@Pointcut("execution(* app.core.dao.coupon.*.*(..))")
	public void inCouponPacage() {
	}

	@Before("(getters() || setters()) && ! inCouponPacage()")
	public void beforeGetOrSet(JoinPoint jp) {
		System.out.println("<><><> (get or set: )" + jp);
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
