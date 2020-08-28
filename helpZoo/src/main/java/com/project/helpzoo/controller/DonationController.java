package com.project.helpzoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/donation/*")
public class DonationController {
	
	// 기부 메인페이지 이동
	@RequestMapping("donationMain")
	public String donationMain() {
		return "donation/donationMain";
		
	}
	
	// 기부 상세페이지 이동
	@RequestMapping("donationDetail")
	public String donationDetail() {
		return "donation/donationDetail";
		
	}
	
	// 기부 등록페이지 이동
	@RequestMapping("donationRegistration")
	public String donationRegistration() {
		return "donation/donationRegistration";
		
	}
	
	// 기부 결제페이지 이동
	@RequestMapping("donationPayment")
	public String donationPayment() {
		return "donation/donationPayment";
		
	}

}
