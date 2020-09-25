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
	public String selectList(@RequestParam(value="curPage", required=false, defaultValue = "0") int curPage,
			@RequestParam(value="pageListSize", required=false, defaultValue = "8") int pageListSize
			,FundingSearch orderSearch) {
	
		
		
		
		
		
		System.out.println(curPage + "커런트페이지");
		
		System.out.println(pageListSize + " 페이지 리스트 사이즈");
		
		List<FundingMainViewDto> mainViewList = service.selectList(orderSearch,curPage,pageListSize);
		
		
		System.out.println(mainViewList);
		
		
			
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
