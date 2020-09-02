package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.board.model.DAO.ReviewDAO;
import com.project.helpzoo.board.model.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDAO reivewDAO;

	// 펀딩 리뷰 게시글 목록 조회 Service 구현
	public List<Review> selectFundingList(int type) {
		return reivewDAO.selectFundingList(type);
	}
	
}
