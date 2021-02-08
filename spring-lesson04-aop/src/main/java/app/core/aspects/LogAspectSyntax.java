package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Component
@Aspect
public class LogAspectSyntax {

	// execution - a pointcut designator
	// in the ():
	// access modifier: if not specified - any
	// return type - mandatory
	// package and class - not mandatory
	// method name - mandatory
	// parameters - mandatory
	// throws - not mandatory

	@Before("execution(public void app.core.dao.company.CompanyDao.addCompany(int, String) throws RuntimeException)")
	public void logSpecific() {
		System.out.println(">>> LOG SPECIFIC");
	}

	// * any return type
	// *. any declared type (package and class)
	// * any method name
	// .. 0 or more parameters of any type
	@Before("execution(* *.*(..))")
	public void logAll() {
		System.out.println(">>> LOG ALL");
	}

}
