package com.project.helpzoo.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.helpzoo.admin.model.service.ABoardService;
import com.project.helpzoo.board.model.vo.Board;

@Controller
@RequestMapping("/admin/board/*")
public class ABoardController {

	@Autowired
	private ABoardService abService;
	
	// 공지사항 관리 페이지 리스트 ------------------------------------------------------
	@RequestMapping("aNoticeList")
	public ModelAndView noticeList(ModelAndView mv) {
		
		List<Board> noticeList = abService.noticeList();
		
		mv.addObject("noticeList", noticeList);
		mv.setViewName("/admin/board/aNoticeList");
		
		return mv;
	}

	// 이벤트 관리 페이지 리스트 ------------------------------------------------------
	@RequestMapping("aEventList")
	public ModelAndView eventList(ModelAndView mv) {
		
		List<Board> eventList = abService.eventList();
		
		mv.addObject("eventList", eventList);
		mv.setViewName("/admin/board/aEventList");

		return mv;
	}
	
	// 펀딩 후기 관리 페이지 리스트 ------------------------------------------------------
	@RequestMapping("aFundingList")
	public ModelAndView ReviewList(ModelAndView mv) {
		
		List<Board> fundingList = abService.fundingList();
		
		mv.addObject("fundingList", fundingList);
		mv.setViewName("/admin/board/aFundingList");
		
		return mv;
	}
		
	// 기부 후기 관리 페이지 리스트 ------------------------------------------------------
	@RequestMapping("aDonationList")
	public ModelAndView donationList(ModelAndView mv) {
		
		List<Board> donationList = abService.donationList();
		
		mv.addObject("donationList", donationList);
		mv.setViewName("/admin/board/aDonationList");
		
		return mv;
	}
	
	// 공지사항 게시물 삭제 ----------------------------------------------------------
	@RequestMapping("delNotice/{boardNo}")
	public String delNotice(@PathVariable int boardNo, Model model,
			HttpServletRequest request, RedirectAttributes rdAttr) {
		
		String status = null;
		String msg = null;
		String url = null;
		
		int confirm = abService.confirmNotice(boardNo);
		
		if(confirm > 0) {
			
			int result = abService.delNotice(boardNo);
			
			if(result > 0) {
				status = "success";
				msg = "게시물이 삭제되었습니다.";
				url = "../aNoticeList";
				
			}else {
				status = "error";
				msg = "게시물 삭제에 실패했습니다.";
				url = request.getHeader("referer"); 
			}
			
		}else {
			status = "error";
			msg = "이미 삭제된 게시물입니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 이벤트 게시물 삭제 ----------------------------------------------------------
	@RequestMapping("delEvent/{boardNo}")
	public String delEvent(@PathVariable int boardNo, Model model,
			HttpServletRequest request, RedirectAttributes rdAttr) {
		
		String status = null;
		String msg = null;
		String url = null;
		
		int confirm = abService.confirmEvent(boardNo);
		
		if(confirm > 0) {
			
			int result = abService.delEvent(boardNo);
			
			if(result > 0) {
				status = "success";
				msg = "게시물이 삭제되었습니다.";
				url = "../aEventList";
				
			}else {
				status = "error";
				msg = "게시물 삭제에 실패했습니다.";
				url = request.getHeader("referer"); 
			}
			
		}else {
			status = "error";
			msg = "이미 삭제된 게시물입니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 펀딩 후기 게시물 삭제 ----------------------------------------------------------
	@RequestMapping("delFunding/{boardNo}")
	public String delFunding(@PathVariable int boardNo, Model model,
			HttpServletRequest request, RedirectAttributes rdAttr) {
		
		String status = null;
		String msg = null;
		String url = null;
		
		int confirm = abService.confirmFunding(boardNo);
		
		if(confirm > 0) {
			
			int result = abService.delFunding(boardNo);
			
			if(result > 0) {
				status = "success";
				msg = "게시물이 삭제되었습니다.";
				url = "../aFundingList";
				
			}else {
				status = "error";
				msg = "게시물 삭제에 실패했습니다.";
				url = request.getHeader("referer"); 
			}
			
		}else {
			status = "error";
			msg = "이미 삭제된 게시물입니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 기부 후기 게시물 삭제 ----------------------------------------------------------
	@RequestMapping("delDonation/{boardNo}")
	public String delDonation(@PathVariable int boardNo, Model model,
			HttpServletRequest request, RedirectAttributes rdAttr) {
		
		String status = null;
		String msg = null;
		String url = null;
		
		int confirm = abService.confirmDonation(boardNo);
		
		if(confirm > 0) {
			
			int result = abService.delDonation(boardNo);
			
			if(result > 0) {
				status = "success";
				msg = "게시물이 삭제되었습니다.";
				url = "../aDonationList";
				
			}else {
				status = "error";
				msg = "게시물 삭제에 실패했습니다.";
				url = request.getHeader("referer"); 
			}
			
		}else {
			status = "error";
			msg = "이미 삭제된 게시물입니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}

	
}
