package app.core.beans.b.lombok;

import java.util.Date;

import lombok.Data;

@Data
public class Coupon {

	private int id;
	private String title;
	private Date expiration;

}
