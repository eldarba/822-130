package app.core.dao.coupon;

import org.springframework.stereotype.Component;

@Component
public class CouponDao {

	public void addCoupon() {
		System.out.println("coupon added");
	}

	public void doWork() {
		System.out.println("CouponDao is doing some work");
	}

	public String getCoupons() {
		System.out.println("getCoupons");
		return "getting your coupons";
	}

	public String setCoupons() {
		System.out.println("setCoupons");
		return "setting your coupons";
	}

}
