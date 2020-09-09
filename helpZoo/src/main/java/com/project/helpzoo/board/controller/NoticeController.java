package com.project.helpzoo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.helpzoo.board.model.service.NoticeService;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// 공지사항 리스트 --------------------------------------------------------------------------------
	// helpzoo/notice/noticeList
	@RequestMapping("noticeList")
	public String noticeMain(@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model model) {
		
		int type = 5; //보드타입: 공지사항 5번
		
		PageInfo pInfo = noticeService.pagination(type, cp);
		
		List<Board> noticeList = noticeService.selectList(pInfo);
		
		//목록 조회 확인용 test
//		for(Board b : noticeList) {
//			System.out.println("공지사항 리스트 : " + b);
//		}
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pInfo", pInfo);
		
		return "notice/noticeMain";
	}
	
	// 공지사항 상세 조회 --------------------------------------------------------------------------------
	// /notice/5/33
	@RequestMapping("{type}/{boardNo}")
	public String noticeView(@PathVariable int type, @PathVariable int boardNo, Model model) {
		
//		int type = 5;
		
		Board board = noticeService.selectNotice(boardNo);
		
		System.out.println("상세조회 결과 : " + board);
		
		model.addAttribute("board", board);
		
		return "notice/noticeView";
	}
	
	// 공지사항 글 작성 뷰 -------------------------------------------------------------------------------------
	@RequestMapping("{type}/insertView")
	public String insertView() {
		
		return "notice/insertView";
		
	}
	
	// 공지사항 글 등록 -------------------------------------------------------------------------------------------
	@RequestMapping("{type}/insertNotice")
	public String insertNotice() {
		
		return null;
	}
	
}
