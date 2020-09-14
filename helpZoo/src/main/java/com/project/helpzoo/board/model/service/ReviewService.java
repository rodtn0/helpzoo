package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.vo.Attachment;
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

	/** 글작성 페이지에 불러올 프로젝트 이미지, 제목 조회 Service
	 * @param type
	 * @return
	 */
	public abstract List<Review> selectInfo(int type, Member loginMember);

	/** 게시글 작성 Service
	 * @param review
	 * @param images
	 * @param savePath
	 * @return result
	 */
	public abstract int insertReview(int type, Review review, List<MultipartFile> images, String savePath);

	
	/** 게시글 상세조회시 이미지 조회 Service
	 * @param type
	 * @param rBoardNo
	 * @return files
	 */
	public abstract List<Attachment> selectFiles(int type, int rBoardNo);

	/** 리뷰 글 삭제 Service
	 * @param type
	 * @param reviewNo
	 * @return result
	 */
	public abstract int deleteReview(int type, int reviewNo);


	
}
