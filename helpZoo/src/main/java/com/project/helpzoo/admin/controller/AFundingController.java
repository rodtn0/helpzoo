package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.project.helpzoo.admin.model.service.AFundingService;
import com.project.helpzoo.admin.model.vo.AFunding;

@Controller
@RequestMapping("/admin/funding/*")
public class AFundingController {

	@Autowired
	private AFundingService afundingService;
	
	@RequestMapping("main")
	public ModelAndView qnaSchedule(ModelAndView mv) {
		
		// 제목, 시작 날짜, 종료 날짜 가져오기
		List<AFunding> funding = afundingService.selectFunding();
		
		for(AFunding fun : funding) {
			System.out.println(fun);
		}
		
		mv.addObject("funding", funding);
		mv.setViewName("admin/funding/adminFSchedule");
		
		return mv;
	}
}
