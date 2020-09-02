package com.project.helpzoo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class reviewController {

	// 펀딩 후기 게시판 버튼 누르면 페이지 전환
	@RequestMapping("review/1")
	public String fundingReviewList() {
		return "board/fundingReviewList";
	}
	
	// 기부 후기 게시판 버튼 누르면 페이지 전환
	@RequestMapping("review/2")
	public String donationREviewList() {
		return "board/donationReviewList";
	}
}
