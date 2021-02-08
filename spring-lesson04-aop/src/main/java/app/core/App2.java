package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.aspects.LogAspectX;
import app.core.dao.company.CompanyDao;
import app.core.dao.coupon.CouponDao;
import app.core.dao.coupon.CouponDao2;

public class App2 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {

			// get the beans
			CompanyDao companyDao = ctx.getBean(CompanyDao.class);
			System.out.println(companyDao.getClass());
			CouponDao couponDao = ctx.getBean(CouponDao.class);
			CouponDao2 couponDao2 = ctx.getBean(CouponDao2.class);

			// invoke beans methods
			companyDao.addCompany(101, "AAA");
			companyDao.sayHello();

			couponDao.addCoupon();
			couponDao.doWork();

			couponDao2.delete();

			System.out.println("==== stats:");
			System.out.println("get invoked: " + LogAspectX.getGetCounter() + " times");

		}

	}

}
