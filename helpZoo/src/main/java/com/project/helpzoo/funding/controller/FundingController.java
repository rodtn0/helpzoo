package com.project.helpzoo.funding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.funding.dto.FundingDetailViewDto;
import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.service.FundingService;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;



@Controller
@RequestMapping("/funding/*")
public class FundingController {
	
	@Autowired
	private FundingService service;
	
	

	
	
	
	@RequestMapping("fundingMain")
	public String fundingMain() {
	
		
		
		return "funding/fundingMain";
	}
	
	@RequestMapping("fundingView/{fundingNo}")
	public String fundingView(@PathVariable int fundingNo, Model model) {
		
		
		FundingDetailViewDto funding = service.selectFunding(fundingNo);
		
		model.addAttribute("funding", funding);
		
		
		
		
		return "funding/fundingDetail";
	}
	
	
	
	
	
	public void fundingStatusChange() {
		
		
		
		service.fundingStatusChange();
		
	
		
	}
	
	
	

	
	
	
	

}
