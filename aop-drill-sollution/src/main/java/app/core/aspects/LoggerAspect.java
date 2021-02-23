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
public class LoggerAspect {

	@Before("addOrDeleteOrLogin()")
	public void addOrDeleteOrLogin(JoinPoint jp) {
		System.out.println(">>> Logger: " + jp.getSignature().getName());
	}

	@Pointcut("add() || delete() || login()")
	public void addOrDeleteOrLogin() {
	};

	@Pointcut("execution(* app.core.*.add*(..))")
	public void add() {
	};

	@Pointcut("execution(* app.core.*.delete*(..))")
	public void delete() {
	};

	@Pointcut("execution(* app.core.*.login(String))")
	public void login() {
	};

}
