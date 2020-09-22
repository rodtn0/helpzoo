package com.project.helpzoo.funding.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.dto.viewDetail.FundingDetailRewardView;
import com.project.helpzoo.funding.model.service.FundingService;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;

@Controller
@RequestMapping("/fundingApi/*")
public class FundingApiController {

	
	
	@Autowired
	private FundingService service;
	
	
	@ResponseBody
	@RequestMapping(value =  "selectList" , produces="text/plain;charset=UTF-8")
	public String selectList(@RequestParam(value="cp", required=false, defaultValue = "1") int cp
			,FundingSearch orderSearch) {
	
		
		
		List<FundingMainViewDto> mainViewList = service.selectList(cp, orderSearch);
		
		
		
			
		Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
		
		
		
		return gson.toJson(mainViewList);
	}
	

	@ResponseBody
	@RequestMapping(value =  "selectReward")
	public String selectRewardList(int fundingNo) {
	
		
		Long fundingNo2 = ((Integer)fundingNo).longValue();
		
		
		List<FundingDetailRewardView> rewardList = service.selectReward(fundingNo2);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
		
		
		System.out.println(rewardList);
		
		return gson.toJson(rewardList);
	}
	
	
	
	
	
	
	
	
}
