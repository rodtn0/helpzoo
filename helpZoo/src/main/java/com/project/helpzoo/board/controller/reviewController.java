package com.project.helpzoo.board.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.board.model.service.ReviewService;
import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.member.model.vo.Member;
import com.project.helpzoo.model.vo.Donation;
import com.project.helpzoo.model.vo.Donation2;

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
		int dBuyCount = 0;
		
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
			
			// --- 기부 참여 프로젝트 개수 조회
			dBuyCount = reviewService.buyCount(type, loginMember);
			System.out.println("기부 참여 개수 : " + dBuyCount);
			
			path = "donationReviewList";
		}
		
		model.addAttribute("fBuyCount", fBuyCount);
		model.addAttribute("dBuyCount", dBuyCount);
		model.addAttribute("pInfo", pInfo);
		model.addAttribute("fReview", fReview);
		model.addAttribute("dReview", dReview);
		
		return "board/" + path;
	}
	
	
	// 후기 글 작성 화면 이동 --> 해당 회원이 구매한 프로젝트가 화면에 떠야하므로 회원정보 가져오기(프로젝트 테이블에서 조회)
	@RequestMapping("writeView/{type}")
	public String writeReviewView(@PathVariable int type, Model model) {
		// 타입이 1이면 펀딩 리뷰작성/ 2면 기부 리뷰작성 화면으로 전환. -> 펀딩게시물/기부게시물에서도 '후기쓰러가기' 버튼에 각각 타입으로 주소 주면됨
		String path = null;
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		
		if(type == 1) {
			List<Review> fInfo = reviewService.selectInfo(type, loginMember);
			System.out.println("fInfo : " + fInfo);
			
			model.addAttribute("fInfo", fInfo);
			
			path = "fReviewWrite";
			
		}else {
			List<Review> dInfo = reviewService.selectInfo(type, loginMember);
			System.out.println("dInfo : " + dInfo);
			
			model.addAttribute("dInfo", dInfo);
			
			path = "dReviewWrite";
		}
		
		
		return "board/" + path;
	}
	
	// 후기 글 상세 조회(펀딩,기부 type으로 구분)
	// board/review/1/510?cp=1
	// board/review/2/100?cp=10
	@RequestMapping("review/{type}/{rBoardNo}")
	public String reviewView(@PathVariable int type, @PathVariable int rBoardNo, Model model) {
		
//		System.out.println("type : " + type);
//		System.out.println("rBoardNo : "+ rBoardNo);
		
		String path = null;
		
		Review fReviewView = null;
		Review dReviewView = null;
		
		if(type == 1) {
			fReviewView = reviewService.selectReviewVeiw(type, rBoardNo);
			System.out.println("상세조회할 글 정보(펀딩) : " + fReviewView);
			
			if(fReviewView != null) { // 게시글 조회가 된다면
				//해당 게시글 이미지 조회하기
				List<Attachment> files = reviewService.selectFiles(type, rBoardNo);
				System.out.println("files : " + files);
				if(!files.isEmpty()) {
					model.addAttribute("files", files);
				}
				
				path = "fReviewView";
				model.addAttribute("fReviewView", fReviewView);
			}
		}else if(type == 2){
			
			dReviewView = reviewService.selectReviewVeiw(type, rBoardNo);
			System.out.println("상세조회할 글 정보(기부) : " + dReviewView);
				
			if(dReviewView != null) {
				List<Attachment> files = reviewService.selectFiles(type, rBoardNo);
				
				if(!files.isEmpty()) {
					model.addAttribute("files", files);
				}
			}
			
				path = "dReviewView";
				model.addAttribute("dReviewView", dReviewView);
			
		}
		
		return "board/" + path;
	}
	
	
	// 후기 글 쓰기
	@RequestMapping(value="writeViewAction/{type}", method=RequestMethod.POST)
	public String insertReview(@PathVariable int type, Review review, Model model,
							   @RequestParam(value="images", required=false) List<MultipartFile> images,
							   RedirectAttributes rdAttr, HttpServletRequest request) {
		
		
		System.out.println("type : " + type);

		// 제목, 내용, 작성자 필요
		
		// 세션에 있는 로그인 정보 얻어오기
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		review.setReviewWriter(loginMember.getMemberNo());
		review.setReviewType(type);
		
		
		for(int i=0; i<images.size(); i++) {
			System.out.println("images[" + i + "] : " + images.get(i).getOriginalFilename());
		}
		
		System.out.println("review : " + review);
		
		// 파일을 저장할 서버 컴퓨터의 로컬 경로
		String savePath = request.getSession().getServletContext().getRealPath("resources/uploadImages");
		
		// 게시글 삽입
		int result = reviewService.insertReview(type, review, images, savePath);
		System.out.println("삽입 결과 : " + result);
		
		String status = null;
		String msg = null;
		String path = null;
		
		
		if(result > 0) {
			status = "success";
			msg = "게시글 등록 성공";
			// http://localhost:8095/helpzoo/board/writeView/1(글 작성 페이지 주소)
			// http://localhost:8095/helpzoo/board/review/1/854?cp=1 (작성 완료했을 때 만들고 싶은 주소-상세페이지 주소)
			path = "../review/" + type + "/" + review.getReviewNo() + "?cp=1";
			model.addAttribute("review", review);
		}else {
			status = "error";
			msg = "게시글 등록 실패";
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + path;
		
	}
	
	// 리뷰 삭제
	// http://localhost:8095/helpzoo/board/review/1/deleteReview/510
	@RequestMapping(value="review/{type}/deleteReview/{reviewNo}", method=RequestMethod.GET)
	public String deleteReview(@PathVariable int type, @PathVariable int reviewNo,
								RedirectAttributes rdAttr, HttpServletRequest request) {
		
		System.out.println(reviewNo);
		
		// 리뷰 내용 삭제하기(status = 'n')
		int result = reviewService.deleteReview(type, reviewNo);
		
		String status = null;
		String msg = null;
		String path = null;
		
		if(result > 0) { // 삭제에 성공하면 목록 1페이지로
			status = "success";
			msg = "게시글 삭제에 성공했습니다.";
			
			// http://localhost:8095/helpzoo/board/review/1/854?cp=1(상세페이지)
			// http://localhost:8095/helpzoo/board/review/1 (삭제 후 목록 1페이지로 가고싶음)
			// redirect 시 제일 앞 "/" 기호는 contextPath를 의미함.
			path = "../";
		}else {
			status = "error";
			msg = "게시글 삭제에 실패했습니다.";
			path = request.getHeader("referer");
		}
		
			rdAttr.addFlashAttribute("status", status);
			rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + path;
	}
	
	// 리뷰 수정 화면 이동(기존 정보 불러오기)
	@RequestMapping("review/{type}/update/{reviewNo}")
	public String updateReview(@PathVariable int type, @PathVariable int reviewNo, Review review, Model model) {
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		String path = null;
		Review fReviewView = null;
		Review dReviewView = null;
		
		// review에 멤버 아이디 저장해서 같이 특정 funding 정보 조회할때 같이 데려가기(id랑 상세조회한 글 번호 가져가야함)
		review.setMemberId(loginMember.getMemberId());
		
		
		if(type == 1) {
			
			fReviewView = reviewService.selectReviewVeiw(type, reviewNo);
			System.out.println("상세조회할 글 정보(펀딩) : " + fReviewView);
			
			Review fInfo = reviewService.selectInfoOne(type, review);
			System.out.println("펀딩 정보 : " + fInfo);
			
			if(fReviewView != null && fInfo != null) { // 게시글 조회가 된다면
				//해당 게시글 이미지 조회하기
				List<Attachment> files = reviewService.selectFiles(type, reviewNo);
				System.out.println("files : " + files);
				
				if(!files.isEmpty()) {
					model.addAttribute("files", files);
				}
				
				path = "fReviewUpdate";
				model.addAttribute("fInfo", fInfo);
				model.addAttribute("fReviewView", fReviewView);
			}
		}else if(type == 2){
			
			dReviewView = reviewService.selectReviewVeiw(type, reviewNo);
			System.out.println("상세조회할 글 정보(기부) : " + dReviewView);
			
			Review dInfo = reviewService.selectInfoOne(type, review);
			System.out.println("기부 정보 : " + dInfo);
				
			if(dReviewView != null && dInfo != null) {
				List<Attachment> files = reviewService.selectFiles(type, reviewNo);
				
				if(!files.isEmpty()) {
					model.addAttribute("files", files);
				}
			}
			
				path = "dReviewUpdate";
				model.addAttribute("dInfo", dInfo);
				model.addAttribute("dReviewView", dReviewView);
			
		}
		
		return "board/" + path;
	}
	
	
	// 리뷰 수정
				// /board/review/1/updateAction/859
	@RequestMapping("review/{type}/updateAction/{reviewNo}")
	public ModelAndView updateAction(@PathVariable int type, @PathVariable int reviewNo,
								 ModelAndView mv,
								 Review review, int cp, boolean[] deleteImages,
								 RedirectAttributes rdAttr,
								 HttpServletRequest request,
								 @RequestParam(value="images", required = false) List<MultipartFile> images) {
		
		System.out.println("cp : " + cp);
		
		System.out.println("deleteImages : " + Arrays.toString(deleteImages));
		
		review.setReviewNo(reviewNo);
		
		// 이미지 수정
		// -------------------------------------------------------------------------------
				
		// 업로드된 파일 이름 확인
		// -> 파일 이름이 출력된 경우 == 이미지가 수정된 경우
		for(int i=0; i<images.size() ; i++) {
			System.out.println("images[" + i + "] : " + images.get(i).getOriginalFilename() );
		}
		
		// 파일 저장 경로 설정
		String savePath = request.getSession().getServletContext().getRealPath("resources/uploadImages");
		
		int result = reviewService.updateReview(type, review, savePath, images, deleteImages);
		// -------------------------------------------------------------------------------
		//int result = boardService.updateBoard(upBoard);
		
		String status = null;
		String msg = null;
		String url = null;
		
		// 수정 성공 시 상세조회 화면으로
		// 현재 : http://localhost:8095/helpzoo/board/review/1/update/860
		// 상세 : http://localhost:8095/helpzoo/board/review/1/881?cp=1
		if(result > 0) {
			status = "success";
			msg = "게시글 수정에 성공하였습니다.";
			url = "../" + reviewNo + "?cp=" + cp;
			//(나)mv.setViewName("redirect:/board/" + type + "/" + boardNo + "?cp=" + cp);
		}else {
			// 실패 시 이전 요청주소(수정화면)
			
			status = "error";
			msg = "게시글 수정에 실패했습니다.";
			url = request.getHeader("referer");
			//(나)mv.setViewName("redirect:" + request.getHeader("referer"));
		}
		
		mv.setViewName("redirect:" + url);
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
				
		return mv;
	}
	
	// 실시간 랭킹 조회
	@ResponseBody
	@RequestMapping("topViews/{type}")
	public String topViews(@PathVariable int type) {
		System.out.println(type);
		
		List<FundingProject> list1 = null;
		List<Donation> list2 = null;
		Gson gson = null;
		String path = null;
		
		if(type == 1) {
			list1 = reviewService.selectTopViewsF();
			gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			
			System.out.println("펀딩 랭킹 조회 : " + list1);
			path = gson.toJson(list1);
			
		}else if(type == 2) {
			list2 = reviewService.selectTopViewsD();
			gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			
			System.out.println("기부 랭킹 조회 : " + list2);
			path = gson.toJson(list2);
		}
		return path;
	}
	
	// 랜덤 조회
	@ResponseBody
	@RequestMapping("random/{type}")
	public String randomBoard(@PathVariable int type) {
		System.out.println(type);
		
		List<FundingMainViewDto> list1 = null;
		List<Donation2> list2 = null;
		Gson gson = null;
		String path = null;
		
		if(type == 1) {
			list1 = reviewService.selectRandomF();
			System.out.println("펀딩 랜덤 조회 : " + list1);
			
			gson = new GsonBuilder().create();
			path = gson.toJson(list1);
			
		}else {
			list2 = reviewService.selectRandomD();
			System.out.println("기부 랜덤 조회 : " + list2);
			
			gson = new GsonBuilder().create();
			path = gson.toJson(list2);

		}
		
		return path;
	}
	
	
	// 급상승 프로젝트 조회
	@ResponseBody
	@RequestMapping("increase/{type}")
	public String increaseBoard(@PathVariable int type) {
		System.out.println(type);
		
		List<FundingMainViewDto> list1 = null;
		List<Donation2> list2 = null;
		Gson gson = null;
		String path = null;
		
		if(type == 1) {
			list1 = reviewService.increaseFunding();
			System.out.println("급상승 펀딩 : " + list1);
			
			gson = new GsonBuilder().create();
			path = gson.toJson(list1);
		}else {
			list2 = reviewService.increaseDonation();
			System.out.println("급상승 기부 : " + list2);
			
			gson = new GsonBuilder().create();
			path = gson.toJson(list2);
		}
		return path;
	}
	
	// 이벤트 랜덤 조회
	@ResponseBody
	@RequestMapping("event")
	public String eventImg() {
		
		List<Board> eventList = reviewService.selectEventImg();
		System.out.println(eventList);
		
		Gson gson = new GsonBuilder().create();
	
		return gson.toJson(eventList);
	}
	
	
	
	
	
}
