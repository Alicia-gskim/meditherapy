package com.pkg.meditherapy.coupon;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pkg.meditherapy.coupon.model.CouponModel;
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
	
	@RequestMapping("/getData")
	public List<CouponModel> getData() throws Exception {
		List<CouponModel> result = couponService.selectList();
		System.out.println(result.get(0));
		
		return result;
	}
}
