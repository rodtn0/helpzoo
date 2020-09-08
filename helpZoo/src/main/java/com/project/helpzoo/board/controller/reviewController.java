package com.project.helpzoo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.helpzoo.board.model.service.ReviewService;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;

@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/board/*")
public class reviewController {

	@Autowired //의존성 주입
	private ReviewService reviewService;
	
	// 펀딩 후기 게시판, 기부 후기 게시판 버튼 누르면 주소에 맞게 목록 조회.
	@RequestMapping("review/{type}")
	public String fundingReviewList(@PathVariable int type, Model model,
								    @RequestParam(value="cp", required=false, defaultValue="1") int cp) {
												// cp 값이 없어서 1로 받아와짐
		
		// 페이징 처리 
		PageInfo pInfo = reviewService.pagiNation(type, cp);
		System.out.println(pInfo);
		System.out.println("시작페이지 : " + pInfo.getStartPage());
		System.out.println("끝페이지 : " + pInfo.getEndPage());
		
		String path = null;
		
		List<Review> fReview = null;
		List<Review> dReview = null;
		
		if(type == 1) {
			
			// 펀딩 후기글 리스트 조회
			fReview = reviewService.selectReviewList(pInfo);
			System.out.println("펀딩 리뷰 게시글 : " + fReview);
			
			path = "fundingReviewList";
			
			
		}else		  {
			dReview = reviewService.selectReviewList(pInfo);
			System.out.println("기부 리뷰 게시글 : " +  dReview);
			
			path = "donationReviewList";
		}
		
		
		model.addAttribute("pInfo", pInfo);
		model.addAttribute("fReview", fReview);
		model.addAttribute("dReview", dReview);
		
		return "board/" + path;
	}
	
	
	// 게시글 작성 화면
	@RequestMapping("writeView/{type}")
	public String writeReview() {
		// 타입이 1이면 펀딩 리뷰작성/ 2면 기부 리뷰작성 화면으로 전환. -> 펀딩게시물/기부게시물에서도 '후기쓰러가기' 버튼에 각각 타입으로 주소 주면됨
		
		return "board/reviewWrite";
	}
}
