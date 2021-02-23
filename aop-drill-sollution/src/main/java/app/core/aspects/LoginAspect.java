package app.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.LoginManager;

@Component
@Aspect
@Order(1)
public class LoginAspect {

	@Autowired
	private LoginManager loginManager;

	@Around("all() && ! login()")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("*** from log aspect");
		if (loginManager.isLogged()) {
			return jp.proceed();
		} else {
			throw new RuntimeException("Blocked by Log Aspect - you are not logged in");
		}
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

	@Pointcut("execution(* app.core.LoginManager.*(..))")
	public void login() {
	};

	@Pointcut("execution(* app.core.*.*(..))")
	public void all() {
	};

}
