package com.project.helpzoo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.helpzoo.board.model.service.ReviewService;
import com.project.helpzoo.board.model.vo.Review;

@Controller
@RequestMapping("/board/*")
public class reviewController {

	@Autowired //의존성 주입
	private ReviewService reviewService;
	
	// 펀딩 후기 게시판, 기부 후기 게시판 버튼 누르면 페이지 전환
	@RequestMapping("review/{type}")
	public String fundingReviewList(@PathVariable int type) {
		
		String path;
		
		if(type == 1) {
			
			
			// 펀딩 후기글 리스트 조회
			List<Review> fReview = reviewService.selectFundingList(type);
			
			
			
			path = "board/fundingReviewList";
		}
		else		  path = "board/donationReviewList";
		
		return path;
	}
	
}
