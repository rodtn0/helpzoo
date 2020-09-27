package com.project.helpzoo.funding.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.board.model.vo.PageInfo;
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
	
	
	@RequestMapping(value =  "selectList")
	public String selectList(
			@RequestParam(value="cp", required=false, defaultValue = "1")int cp,
			
			
			FundingSearch orderSearch , Model model) {
		
		
		
		PageInfo pInfo = service.pagination(cp);
		
		
		pInfo.setLimit(9);
		
		
		List<FundingMainViewDto> fundingList = service.selectList(pInfo);
	
		
		model.addAttribute("fundingList", fundingList);
		
		model.addAttribute("pInfo", pInfo);
		
		
		
		return "funding/fundingMain";
	}
	
	
	
	
	// 게시글 검색
		// search/1?&sKey=tit&sVal=test
		@RequestMapping("search")
		public String search(@PathVariable int type, 
							 @RequestParam(value="cp", required = false, defaultValue = "1") int cp,
							 FundingSearch search, Model model) {
			
			
			
			
			PageInfo pInfo = null;
			
			List<FundingMainViewDto> fundingList = service.selectSearchList(search,pInfo);
			
	
			
			model.addAttribute("fundingList", fundingList);
			model.addAttribute("pInfo", pInfo);
		
			
			return "funding/fundingMain";
		
		
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
