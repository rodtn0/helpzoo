package com.project.helpzoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.helpzoo.model.service.DonationService;
import com.project.helpzoo.model.vo.Attachment;
import com.project.helpzoo.model.vo.Donation;
import com.project.helpzoo.model.vo.PageInfo;


@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/donation/*")
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	// 기부 메인페이지 이동
	@RequestMapping("donationMain/{type}")
	public String donationMain(@PathVariable int type, 
			@RequestParam(value="cp", required = false, defaultValue = "2") int cp
			,Model model) {
		
		PageInfo pInfo = donationService.pagination(type, cp);
		
		List<Donation> donationList = donationService.selectList(pInfo);

		for(Donation donation : donationList) {
			//System.out.println(b);
		}
		
		//----------------------------------------------------------------
		// 4) 썸네일 목록 조회
		if(!donationList.isEmpty()) { // 게시글 목록 조회 결과가 있을 경우
			// Mybatis List 조회 시 조회 결과가 없어도 비어 있는 List[]가 반환 됨
			List<Attachment> thList = donationService.selectThumbnailList(donationList);
			/*
			 * for(Attachment at : thList) { System.out.println("at : " +at); }
			 */
			model.addAttribute("thList", thList);
		}
		
		model.addAttribute("donationList", donationList);
		model.addAttribute("pInfo", pInfo);
		
		
		
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
