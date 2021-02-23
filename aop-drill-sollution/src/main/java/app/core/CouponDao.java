package app.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CouponDao {

	private Map<Integer, Coupon> couponsMap = new HashMap<>();

	public void addCoupon(Coupon coupon) {
		System.out.println("addCoupon");
		couponsMap.put(coupon.getId(), coupon);
	}

	public Coupon getCoupon(int couponId) {
		System.out.println("getCoupon");
		return couponsMap.get(couponId);
	}

	public Collection<Coupon> getAllCoupons() {
		System.out.println("getAllCoupons");
		return couponsMap.values();
	}

	public boolean deleteCoupon(int couponId) {
		System.out.println("deleteCoupon");
		return couponsMap.remove(couponId) != null ? true : false;
	}

}
