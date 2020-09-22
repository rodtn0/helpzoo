package com.project.helpzoo.funding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.viewDetail.FundingDetailRewardView;
import com.project.helpzoo.funding.model.service.FundingService;


	
	

	@Controller
	@RequestMapping("/fundingAttend/*")
	public class FundingAttendController {

		
		@Autowired
		private FundingService service;
		
		
		
		
		@RequestMapping("rewardChoice/{fundingNo}")
		public String fundingView(@PathVariable int fundingNo, Model model) {
			

			Long fundingNo2 = ((Integer)fundingNo).longValue();
			
			
			
			List<FundingDetailRewardView> rewardList = service.selectReward(fundingNo2);
			
			
			model.addAttribute("rewardList", rewardList);
			
			return "funding/fundingAttend";
			
			
		}
		
		
		
		
		
		
		
		
}
