package com.pkg.meditherapy.coupon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pkg.meditherapy.coupon.model.CouponModel;

@Mapper
@Repository
public interface CouponMapper {
	public String getDual() throws Exception;
	public List<CouponModel> selectList() throws Exception;
}
