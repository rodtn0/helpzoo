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
import com.project.helpzoo.member.model.vo.Member;

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
		int fBuyCount = 0;
		
		// 세션에 저장된 로그인 멤버 정보 가져오기
		Member loginMember = (Member)model.getAttribute("loginMember");
		System.out.println("회원 정보 : " + loginMember);
		
		if(type == 1) {
			
			// 펀딩 후기글 리스트 조회
			fReview = reviewService.selectReviewList(pInfo);
			System.out.println("펀딩 리뷰 게시글 : " + fReview);
			
			// ---- 펀딩 구매내역 조회(count로 개수 조회)
			// -- 로그인한 멤버의 회원번호
			fBuyCount = reviewService.buyCount(type, loginMember);
			System.out.println("구매 프로젝트 개수 : " + fBuyCount);
			
			path = "fundingReviewList";
			
			
		}else		  {
			dReview = reviewService.selectReviewList(pInfo);
			System.out.println("기부 리뷰 게시글 : " +  dReview);
			
			// 기부 개수 조회
			//int dBuyCount = reviewService.buyCount(type, loginMember);
			
			
			path = "donationReviewList";
		}
		
		model.addAttribute("fBuyCount", fBuyCount);
		model.addAttribute("pInfo", pInfo);
		model.addAttribute("fReview", fReview);
		model.addAttribute("dReview", dReview);
		
		return "board/" + path;
	}
	
	
	// 후기 글 작성 화면 이동
	@RequestMapping("writeView/{type}")
	public String writeReviewView() {
		// 타입이 1이면 펀딩 리뷰작성/ 2면 기부 리뷰작성 화면으로 전환. -> 펀딩게시물/기부게시물에서도 '후기쓰러가기' 버튼에 각각 타입으로 주소 주면됨
		return "board/reviewWrite";
	}
	
	// 후기 글 상세 조회(펀딩,기부 type으로 구분)
	// board/review/1/510?cp=1
	@RequestMapping("review/{type}/{rBoardNo}")
	public String reviewView(@PathVariable int type, @PathVariable int rBoardNo) {
		
		String path = null;
		
		if(type == 1) {
			
		Review fReviewView = reviewService.selectReviewVeiw(type, rBoardNo);
			
		}else {
			
		}
		
		
		
		return "board/reviewView";
	}
	
	
	// 후기 글 쓰기
	//@RequestMapping("writeView/{type}/upload")
	//public String insertReview(@PathVariable int type) {
		
		// 제목, 내용, 작성자 필요
	//	return "";
	//}
	
}
