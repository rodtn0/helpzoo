package com.project.helpzoo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	// 공지사항 리스트
	@RequestMapping("noticeList")
	public String noticeMain(@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model modelModel) {
		
		int type = 5;
		
		return "notice/noticeMain";
	}
	
	
}
