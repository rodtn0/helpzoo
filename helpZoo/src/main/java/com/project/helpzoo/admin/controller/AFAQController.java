package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.helpzoo.admin.model.service.AFAQService;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.member.model.vo.Member;

@SessionAttributes({"loginMember"})
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
	
	// 게시글 등록 화면 이동
	@RequestMapping("createFAQ")
	public String insertView() {
		return "admin/faq/adminFaqInsert";
	}
	
	@RequestMapping("insertAction")
	public String insertAction(Board board, Model model,
			RedirectAttributes rdAttr) {
		
		Member loginMember =(Member)model.getAttribute("loginMember");
		
		board.setBoardWriter(loginMember.getMemberNo()+"");
		System.out.println(board);
		
		int result = fService.insertBoard(board);
		
		String status = null;
		String msg = null;
		String url = null;
		
		if(result > 0) {
			status= "success";
			msg = "등록되었습니다.";
			url = "faqList";
		}else {
			status= "error";
			msg= "실패하였습니다.";
			url = "faqList";
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		
		return "redirect:"+url;
	}
	
	

}
