package com.project.helpzoo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.helpzoo.board.model.service.ReviewService;
import com.project.helpzoo.board.model.vo.Review;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/board/*")
public class reviewController {

	@Autowired //의존성 주입
	private ReviewService reviewService;
	
	// 펀딩 후기 게시판, 기부 후기 게시판 버튼 누르면 주소에 맞게 목록 조회.
	@RequestMapping("review/{type}")
	public String fundingReviewList(@PathVariable int type, Model model) {
		
		String path = null;
		List<Review> fReview = null;
		List<Review> dReview = null;
		
		if(type == 1) {
			
			// 펀딩 후기글 리스트 조회
			fReview = reviewService.selectReviewList(type);
			System.out.println(fReview);
			
			path = "fundingReviewList";
			
			
		}else		  {
			dReview = reviewService.selectReviewList(type);
			System.out.println(dReview);
			
			path = "donationReviewList";
		}
		
		model.addAttribute("fReview", fReview);
		model.addAttribute("dReview", dReview);
		
		return "board/" + path;
	}
	
}
