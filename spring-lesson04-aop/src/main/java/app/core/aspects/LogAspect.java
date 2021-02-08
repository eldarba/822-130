package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("execution(public void app.core.dao.company.CompanyDao.addCompany(int, String) throws RuntimeException)")
	public void logSpecific() {
		System.out.println(">>> LOG SPECIFIC");
	}

	@Before("execution(* *.*(..))")
	public void logAll() {
		System.out.println(">>> LOG ALL");
	}

}
