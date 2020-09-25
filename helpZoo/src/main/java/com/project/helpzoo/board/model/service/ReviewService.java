package com.project.helpzoo.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.model.vo.funding.FundingAttachment;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.member.model.vo.Member;
import com.project.helpzoo.model.vo.Donation;
import com.project.helpzoo.model.vo.Donation2;

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

	/** 특정 번호의 (펀딩,기부)프로젝트 정보 조회 Service
	 * @param type
	 * @param review
	 * @return fInfo,dInfo
 	 */
	public abstract Review selectInfoOne(int type, Review review);

	/** 리뷰 수정 Service
	 * @param review
	 * @param savePath
	 * @param images
	 * @param deleteImages
	 * @return result
	 */
	public abstract int updateReview(int type, Review review, String savePath, List<MultipartFile> images,
			boolean[] deleteImages);

	/** 기부 top5 랭킹 조회 Service
	 * @return list
	 */
	public abstract List<Donation> selectTopViewsD();

	/** 펀딩 top5 랭킹 조회 Service
	 * @return
	 */
	public abstract List<FundingProject> selectTopViewsF();

	/** 펀딩 랜덤 3개 조회
	 * @return list1
	 */
	public abstract List<FundingMainViewDto> selectRandomF();

	/** 기부 랜덤 3개 조회
	 * @return list2
	 */
	public abstract List<Donation2> selectRandomD();

	/** 급상승 기부 조회 Service
	 * @return list2
	 */
	public abstract List<Donation2> increaseDonation();

	
	/** 급상승 펀딩 조회 Service
	 * @return list1
	 */
	public abstract List<FundingMainViewDto> increaseFunding();

	/** 이벤트 이미지 조회 Service
	 * @return eventList
	 */
	public abstract List<Board> selectEventImg();

	/**  펀딩 리뷰 좋아요 수 조회
	 * @param reviewNo 
	 * @return listCount
	 */
	public abstract int likeCount(int reviewNo);
	
	/** 기부 리뷰 좋아요 수 조회
	 * @param reviewNo
	 * @return
	 */
	public abstract int likeCount2(int reviewNo);

	/** 펀딩 리뷰 클릭시 좋아요 수 insert
	 * @param map
	 * @return result
	 */
	public abstract int insertCount(Map<String, Object> map);
	
	/** 기부 리뷰 클릭시 좋아요 수 insert
	 * @param map
	 * @return
	 */
	public abstract int insertCount2(Map<String, Object> map);
	

	/** 펀딩 리뷰 좋아요 삭제 Service
	 * @param map
	 * @return result
	 */
	public abstract int deleteCount(Map<String, Object> map);

	/** 기부 리뷰 좋아요 삭제 Service
	 * @param map
	 * @return result
	 */
	public abstract int deleteCount2(Map<String, Object> map);


	



	
}
