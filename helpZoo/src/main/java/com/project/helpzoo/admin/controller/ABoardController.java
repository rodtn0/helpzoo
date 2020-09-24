package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	
}
