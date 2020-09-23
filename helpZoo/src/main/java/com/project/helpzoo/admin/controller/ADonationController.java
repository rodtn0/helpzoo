package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.helpzoo.admin.model.service.ADonationService;
import com.project.helpzoo.model.vo.Donation2;

@Controller
@RequestMapping("/admin/donation/*")
public class ADonationController {
	
	@Autowired
	private ADonationService adonationService;
	
	@RequestMapping("main")
	public ModelAndView donationList(ModelAndView mv) {
		
		List<Donation2> donationList = adonationService.selectList();
		
		for(Donation2 dl : donationList) {
			System.out.println(dl);
		}
		
		mv.addObject("donationList", donationList);
		mv.setViewName("admin/donation/adminDonationMain");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("deleteDonation")
	public String deleteDonation(String donationNo) {
		
		int result = adonationService.deleteDonation(donationNo);
		
		return result+"";
	}
}
