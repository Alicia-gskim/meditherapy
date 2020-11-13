package com.pkg.meditherapy.coupon.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponModel implements Serializable {
	private static final long serialVersionUID = -5581589360728347575L;
	
	private String cafe24MemberId;
	private int category;
	private String cdate;
	private String detailImage;
	private String discountprice;
	private String display;
	private String downloadFiles;
	private int idx;
	private String listImage;
	private String mallId;
	private String mdate;
	private String optionCode;
	private String originClassification;
	private int originPlaceNo;
	private String originPlaceValue;
	private int price;
	private String productCode;
	private String productName;
	private int product_no;
	private String selling;
	private String serialId;
	private String smallImage;
	private String soldOut;
	private String summaryDescription;
	private int targetProduct;
	private String tinyImage;
	private String title;
	private String useLimitDate;
	private String useLimitDay;
	private String useLimitPrice;
}