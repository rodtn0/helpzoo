package com.project.helpzoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"loginMember"})
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
	@RequestMapping("donationRegist1")
	public String donationRegistration1() {
		return "donation/donationRegist1";
		
	}
	// 기부 등록페이지 이동
	@RequestMapping("donationRegist2")
	public String donationRegistration2() {
		return "donation/donationRegist2";
		
	}
	// 기부 등록페이지 이동
	@RequestMapping("donationRegist3")
	public String donationRegistration3() {
		return "donation/donationRegist3";
		
	}
	
	// 기부 결제페이지 이동
	@RequestMapping("dPaymentOnec")
	public String dPaymentOnec() {
		return "donation/dPaymentOnec";
		
	}
	
	// 기부 결제페이지 이동
	@RequestMapping("dPaymentMontly")
	public String dPaymentMontly() {
		return "donation/dPaymentMontly";
		
	}

}
