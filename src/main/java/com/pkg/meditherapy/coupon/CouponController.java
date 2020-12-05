package com.pkg.meditherapy.coupon;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pkg.meditherapy.coupon.model.CouponModel;
import com.pkg.meditherapy.coupon.model.IssuingCoupons;
import com.pkg.meditherapy.coupon.service.CouponService;

@RestController
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@RequestMapping("/")
	public ModelAndView index() throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("now", couponService.getDual());
		mav.addObject("str", "Now Time : ");
		
		return mav;
	}
	
	@RequestMapping("/sample")
	public ModelAndView sample() throws Exception {
		ModelAndView mav = new ModelAndView("jsp/sample");
		mav.addObject("time", couponService.getDual());
		mav.addObject("str", "Hello!");
		
		return mav;
	}
	
	/**
	 * 계정별 발급된 쿠폰 목록 조회
	 */
	@RequestMapping("/getData")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<CouponModel> getData(IssuingCoupons vo, HttpServletResponse response) throws Exception {
		if( vo.getUserId() != null ) {
			System.out.println("## 0 ## getData : " + vo.getUserId());
		}
		ModelAndView mav = new ModelAndView("jsonView");
		List<CouponModel> result = couponService.selectList(vo);
		System.out.println("## 1 ## coupon size : " + result.size());
		mav.addObject("data", result);
		
		return result;
	}
	
	/**
	 * 쿠폰발급
	 */
	@RequestMapping("/issuingCoupons")
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public boolean getIssuingCoupons(IssuingCoupons vo) throws Exception {
		System.out.println("## 0 ## issuingCoupons : " + vo.getUserId() + ", " + vo.getCouponId());
		return couponService.getIssuingCoupons(vo);
	}
	
	/**
	 * 발급 된 쿠폰 사용
	 */
	@RequestMapping("/usingCoupon")
	public boolean usingCoupon(IssuingCoupons vo) throws Exception {
		System.out.println("## 0 ## usingCoupon : " + vo.getUserId() + ", " + vo.getCouponId());
		return couponService.usingCoupon(vo);
	}
}
