package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;
import com.project.helpzoo.member.model.vo.Member;

public interface ReviewService {

	/** 리뷰 게시판 페이징 Service
	 * @param type
	 * @param cp
	 * @return pInfo
	 */
	public abstract PageInfo pagiNation(int type, int cp);
	
	/** 리뷰 게시글 목록 조회 Service
	 * @param type
	 * @return 
	 */
	public abstract List<Review> selectReviewList(PageInfo pInfo);

	/** 구매 여부 확인 Service
	 * @param type
	 * @return fBuyCount
	 */
	public abstract int buyCount(int type, Member loginMember);

	/** 리뷰 상세조회 Service
	 * @param rBoardNo
	 * @return
	 */
	public abstract Review selectReviewVeiw(int type, int rBoardNo);


	
}
