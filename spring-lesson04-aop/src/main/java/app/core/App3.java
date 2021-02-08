package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.aspects.StatisticsAspectDeclarations;
import app.core.dao.company.CompanyDao;
import app.core.dao.coupon.CouponDao;
import app.core.dao.coupon.CouponDao2;

public class App3 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {

			// get the beans
			CompanyDao companyDao = ctx.getBean(CompanyDao.class);
			CouponDao couponDao = ctx.getBean(CouponDao.class);
			CouponDao2 couponDao2 = ctx.getBean(CouponDao2.class);

			// invoke beans methods
			companyDao.getCompanies();
			couponDao.getCoupons();
			companyDao.getCompanies();
			couponDao.setCoupons();

			System.out.println("==== stats:");
			System.out.println("get invoked: " + StatisticsAspectDeclarations.getGetCounter() + " times");
			System.out.println("set invoked: " + StatisticsAspectDeclarations.getSetCounter() + " times");

		}

	}

}
