package app.core.dao.coupon;

import org.springframework.stereotype.Component;

@Component
public class CouponDao2 {

	public void printCoupons() {
		System.out.println("coupons list:");
	}

	public void delete() {
		System.out.println("delete all coupons");
	}

}
