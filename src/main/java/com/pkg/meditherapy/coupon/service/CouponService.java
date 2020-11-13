package com.pkg.meditherapy.coupon.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.meditherapy.coupon.mapper.CouponMapper;
import com.pkg.meditherapy.coupon.model.CouponModel;

@Service
public class CouponService {
	
	@Autowired
	private CouponMapper couponMapper;
	
	public String getDual() throws Exception {
		return couponMapper.getDual();
	}
	
	public List<CouponModel> selectList() throws Exception {
		List<CouponModel> list = couponMapper.selectList();
		return list;
	}
}
