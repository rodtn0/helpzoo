package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.board.model.DAO.ReviewDAO;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;
import com.project.helpzoo.member.model.vo.Member;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private PageInfo pInfo;
	

	
	
	// 페이징 처리를 위한 Service 구현
	@Override
	public PageInfo pagiNation(int type, int cp) {
		
		// 전체 게시글 수 조회
		int  listCount = reviewDAO.getListCount(type);
		System.out.println(listCount);
		// setPageInfo 호출
		pInfo.setPageInfo(cp, listCount, type);
		
		return pInfo;
	}
	
	
	// 리뷰 게시글 목록 조회 Service 구현
	@Override
	public List<Review> selectReviewList(PageInfo pInfo) {
		return reviewDAO.selectReviewList(pInfo);
		
	}

	// 구매 여부 확인 Service 구현
	@Override
	public int buyCount(int type, Member loginMember) {
		return reviewDAO.buyCount(type, loginMember);
	}

	// 리뷰 상세조회 Service 구현
	@Override
	public Review selectReviewVeiw(int type, int rBoardNo) {
		return reviewDAO.selectReviewView(type, rBoardNo);
	}
}
