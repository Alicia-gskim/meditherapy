package com.pkg.meditherapy.coupon.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssuingCoupons implements Serializable {
	private static final long serialVersionUID = 7284100797097403642L;
	
	private String userId;
	private String couponId;
	private String useFlag;
}
