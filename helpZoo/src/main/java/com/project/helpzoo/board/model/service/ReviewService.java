package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.Review;

public interface ReviewService {

	
	/** 펀딩 리뷰 게시글 목록 조회 Service
	 * @param type
	 * @return fReview
	 */
	public abstract List<Review> selectFundingList();

	
}
