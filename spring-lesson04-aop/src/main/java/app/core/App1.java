package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.dao.company.CompanyDao;
import app.core.dao.coupon.CouponDao;

public class App1 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {

			// get the beans
			CompanyDao companyDao = ctx.getBean(CompanyDao.class);
			CouponDao couponDao = ctx.getBean(CouponDao.class);

			// invoke beans methods
			companyDao.addCompany(101, "AAA");
			companyDao.sayHello();

			couponDao.addCoupon();
			couponDao.doWork();

		}

	}

}
