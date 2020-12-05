package com.pkg.meditherapy.coupon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.meditherapy.coupon.mapper.CouponMapper;
import com.pkg.meditherapy.coupon.model.CouponModel;
import com.pkg.meditherapy.coupon.model.IssuingCoupons;

@Service
public class CouponService {
	
	@Autowired
	private CouponMapper couponMapper;
	
	public String getDual() throws Exception {
		return couponMapper.getDual();
	}
	
	/**
	 * 쿠폰 발급하기
	 */
	public boolean getIssuingCoupons(IssuingCoupons issuingCoupons) throws Exception {
		System.out.println("## 1 ## 쿠폰 발급 : " + issuingCoupons.getCouponId());
		boolean resStatus = true;
		
		List<String> strArr = new ArrayList<String>();
		strArr.add("coupon1");
		strArr.add("coupon2");
		strArr.add("coupon3");
		
		int cnt = couponMapper.getIssuingCoupons(issuingCoupons);
		System.out.println("## 2 ## getIssuingCoupons : " + cnt);
		if( issuingCoupons.getCouponId().equals("couponA") ) {
			// 모든 쿠폰 발급
			if( cnt < 3 ) {
				// 아이디가 발급한 쿠폰이 3개가 아닌 경우
				List<String> couponList = couponMapper.checkCouponsById(issuingCoupons);
				
				for(String str : couponList) {
					switch(str) {
						case "coupon1" :
							strArr.remove("coupon1");
							break;
						case "coupon2" :
							strArr.remove("coupon2");
							break;
						case "coupon3" :
							strArr.remove("coupon3");
							break;
					}
				}
				
				for(String couponId : strArr) {
					IssuingCoupons newCoupon = new IssuingCoupons();
					newCoupon.setUserId(issuingCoupons.getUserId());
					newCoupon.setCouponId(couponId);
					
					couponMapper.insertIssuingCoupons(newCoupon);
				}
			} else {
				System.out.println("이미 모두 발급 된 쿠폰입니다.");
				resStatus = false;
			}
		} else {
			// 개별 쿠폰 발급
			if( cnt == 0 ) {
				// 선택한 쿠폰만 발급
				couponMapper.insertIssuingCoupons(issuingCoupons);
			} else {
				System.out.println(issuingCoupons.getCouponId() + " 쿠폰은 이미 발급 된 쿠폰입니다.");
				resStatus = false;
			}
		}
		
		System.out.println("## 2 ## resStatus : " + resStatus);
		
		return resStatus;
	}
	
	/**
	 * 계정별 발급된 쿠폰 목록 조회
	 */
	public List<CouponModel> selectList(IssuingCoupons vo) throws Exception {
		List<CouponModel> list = couponMapper.selectList(vo);
		return list;
	}
	
	/**
	 * 발급 된 쿠폰 사용
	 */
	public boolean usingCoupon(IssuingCoupons vo) throws Exception {
		int cnt = couponMapper.usingCoupon(vo);
		if(cnt > 0) {
			return true;
		} else {
			return false;
		}
	}
}
