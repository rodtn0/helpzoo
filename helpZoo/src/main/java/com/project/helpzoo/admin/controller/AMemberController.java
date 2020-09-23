package com.project.helpzoo.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 멤버 계정 정지 ---------------------------------------------------------------------
	@RequestMapping("delMember/{memberNo}")
	public String delMember(@PathVariable int memberNo,	Model model,
			HttpServletRequest request, RedirectAttributes rdAttr) {
		// SweetAlert용 변수 선언
		String status = null;
		String msg = null;
		String url = null;
		
		System.out.println("멤버번호 : " + memberNo);
		
		// 계정 상태 확인
		int confirm = amService.selMember(memberNo);
		
		if(confirm > 0) {
			
			int result = amService.delMember(memberNo);
			
			if(result > 0) {
				status = "success";
				msg = "멤버 계정이 정지되었습니다.";
				url = "../aMemberList";
		
			}else {
				status = "error";
				msg = "멤버 계정 정지에 실패했습니다.";
				url = request.getHeader("referer"); 
			}

		}else {
			status = "error";
			msg = "이미 정지된 계정입니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}

	
}
