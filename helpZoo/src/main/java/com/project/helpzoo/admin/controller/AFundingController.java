package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.admin.model.service.AFundingService;
import com.project.helpzoo.admin.model.vo.AFunding;
import com.project.helpzoo.admin.model.vo.AFundingCategory;

@Controller
@RequestMapping("/admin/funding/*")
public class AFundingController {

	@Autowired
	private AFundingService afundingService;
	
	@RequestMapping("main")
	public ModelAndView fundingSchedule(ModelAndView mv) {
		
		// 제목, 시작 날짜, 종료 날짜 가져오기
		List<AFunding> funding = afundingService.selectFunding();
		
		for(AFunding fun : funding) {
			System.out.println(fun);
		}
		
		System.out.println("con" + funding);
		
		mv.addObject("funding", funding);
		mv.setViewName("admin/funding/adminFSchedule");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="updateAction",
			produces="application/text; charset=utf-8;")
	public String fundingUpdate(AFunding funding) {
		System.out.println(funding);
		
		int result = afundingService.updateFunding(funding);
		
		return result+"";
	}
	
	@ResponseBody
	@RequestMapping(value="deleteAction",
			produces="application/text; charset=utf-8;")
	public String fundingDelete(String fundingNo) {
		System.out.println(fundingNo);
		
		int result = afundingService.deleteFunding(fundingNo);
		
		return result+"";
	}
	
	@ResponseBody
	@RequestMapping("listAction")
	public String fundingList(String listStatus, ModelAndView mv) {
		
		
		List<AFunding> funding = afundingService.selectFSList(listStatus);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		return gson.toJson(funding);
		
	}
	
	@RequestMapping("chart")
	public ModelAndView fundingChart(ModelAndView mv) {
		
		mv.setViewName("admin/funding/adminFChart");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("MonthFee")
	public String MonthFee(String yy) {
		System.out.println(yy);
		
		List<AFunding> monthFee = afundingService.selectMonthFee(yy);
		
		System.out.println(monthFee);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		return gson.toJson(monthFee);
	}
	
	@ResponseBody
	@RequestMapping("MonthCategory")
	public String MonthCategory(String yymm) {
		System.out.println(yymm);
		
		List<AFundingCategory> monthCategory =afundingService.selectCategory(yymm);
		
		System.out.println(monthCategory);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		return gson.toJson(monthCategory);
	}
	
	@ResponseBody
	@RequestMapping("MonthSuccess")
	public String MonthSuccess(String yymm) {
		System.out.println(yymm);
		
		List<AFunding> monthSuccess = afundingService.selectSuccess(yymm);
		
		System.out.println(monthSuccess);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		return gson.toJson(monthSuccess);
		
	}
	
}
