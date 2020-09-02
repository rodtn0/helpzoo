package com.project.helpzoo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.helpzoo.board.model.service.NoticeService;
import com.project.helpzoo.board.model.vo.Board;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//공지사항 리스트
	@RequestMapping("noticeList")
	public String noticeMain(@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model model) {
		
		int type = 5; //보드타입: 공지사항 5번
		
		List<Board> noticeList = noticeService.selectList(type);
		
		//목록 조회 확인용 test
		for(Board b : noticeList) {
			System.out.println("공지사항 리스트 : " + b);
		}
		
		model.addAttribute("noticeList", noticeList);
		
		return "notice/noticeMain";
	}
	
	
}
