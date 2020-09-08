package com.project.helpzoo.funding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.funding.HibernateProxyTypeAdapter;
import com.project.helpzoo.funding.model.service.FundingService;
import com.project.helpzoo.funding.model.vo.FundingProject;



@Controller
@RequestMapping("/funding/*")
public class fundingController {
	
	@Autowired
	private FundingService service;
	
	
	
	@RequestMapping("fundingMain")
	public String fundingMain() {
	
		
		
		
		
		return "funding/fundingMain";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value =  "selectList" , produces="text/plain;charset=UTF-8"
 )
	public String selectList(int cp) {
	
		
		
		List<FundingProject> fundingList = service.selectList(cp);
		
		
		Gson gson = new Gson();
		
		
		for(FundingProject fn: fundingList) {
			System.out.println("펀딩리스트 : " + fn.getGoalAmount());
		}
		
		
		return gson.toJson(fundingList);
	}
	
	
	
	
	

}
