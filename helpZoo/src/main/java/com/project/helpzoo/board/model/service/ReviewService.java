package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;

public interface ReviewService {

	/** 펀딩 리뷰 게시판 페이징 Service
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


	
}
