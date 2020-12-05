package com.pkg.meditherapy.coupon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pkg.meditherapy.coupon.model.CouponModel;
import com.pkg.meditherapy.coupon.model.IssuingCoupons;

@Mapper
@Repository
public interface CouponMapper {
	public String getDual() throws Exception;
	public List<CouponModel> selectList(IssuingCoupons vo) throws Exception;
	
	public List<String> checkCouponsById(IssuingCoupons vo) throws Exception;
	public int getIssuingCoupons(IssuingCoupons vo) throws Exception;
	public int insertIssuingCoupons(IssuingCoupons vo) throws Exception;
	
	public int usingCoupon(IssuingCoupons vo) throws Exception;
}
