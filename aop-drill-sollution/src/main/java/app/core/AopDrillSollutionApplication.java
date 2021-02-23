package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.aspects.StatistaicsAspect;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopDrillSollutionApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(AopDrillSollutionApplication.class, args);

		LoginManager lg = ctx.getBean(LoginManager.class);
		CouponDao couponDao = ctx.getBean(CouponDao.class);
		CompanyDao companyDao = ctx.getBean(CompanyDao.class);

		lg.login("aaa");

		couponDao.addCoupon(new Coupon());
		couponDao.addCoupon(new Coupon());

		System.out.println(couponDao.getAllCoupons());
		couponDao.deleteCoupon(1);

		companyDao.addCompany(new Company());
		System.out.println(companyDao.getAllCompanies());

		lg.logout();

		StatistaicsAspect stats = ctx.getBean(StatistaicsAspect.class);
		System.out.println("number of get calls: " + stats.getNumberOfGetCalls());

	}

}
