package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.helpzoo.admin.model.service.AFAQService;
import com.project.helpzoo.board.model.vo.Board;

@Controller
@RequestMapping("/admin/faq/*")
public class AFAQController {
	
	@Autowired
	private AFAQService fService;
	
	@RequestMapping("faqList")
	public ModelAndView faqList(ModelAndView mv) {
		int type = 3;
		
		List<Board> faqList = fService.selectFaqList(type);
		
		mv.addObject("faqList", faqList);
		mv.setViewName("admin/faq/adminFaqMain");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("deleteFAQ")
	public String deleteFAQ(String FAQNo) {
		
		int result = fService.deleteFaq(FAQNo);
		
		return result+"";
	}
	
	

}
