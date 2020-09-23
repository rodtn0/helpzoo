package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.helpzoo.admin.model.service.AMemberService;
import com.project.helpzoo.member.model.vo.Member;

@Controller
@RequestMapping("/admin/member/*")
public class AMemberController {

	@Autowired
	private AMemberService amService;

	// 관리자 멤버 관리 페이지 리스트 ----------------------------------------------------------
	@RequestMapping("aMemberList")
	public ModelAndView memberList(ModelAndView mv) {

		List<Member> memberList = amService.memberList();
		
		mv.addObject("memberList", memberList);
		mv.setViewName("/admin/amember/aMemberView");
		
		return mv;
	}

	
}
