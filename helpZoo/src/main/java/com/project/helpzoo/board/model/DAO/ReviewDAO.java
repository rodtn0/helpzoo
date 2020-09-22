package com.project.helpzoo.board.model.DAO;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.member.model.vo.Member;
import com.project.helpzoo.model.vo.Donation;

@Repository
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 페이징 처리 DAO
	 * @param type
	 * @return listCount
	 */
	public int getListCount(int type) {
		String mapperId = null;
		
		if(type == 1) mapperId = "reviewMapper.getFundingListCount";
		else 		  mapperId = "reviewMapper.getDonationListCount";
		return sqlSession.selectOne(mapperId);
	}
	
	
	/** 후기 게시판 목록 조회DAO
	 * @param type
	 * @return 
	 */
	public List<Review> selectReviewList(PageInfo pInfo) {
		
		// 건너 뛸 게시글 수 지정
		int offset = (pInfo.getCurrentPage() - 1) * pInfo.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
		
		String mapperId = null;
		
		System.out.println(pInfo.getBoardType());
		if(pInfo.getBoardType() == 1) mapperId = "reviewMapper.selectFundingList";
		else		  				  mapperId = "reviewMapper.selectDonationList";
		
		return sqlSession.selectList(mapperId, null, rowBounds);
	}


	/** 구매(참여) 내역 확인 DAO
	 * @param type
	 * @return 
	 */
	public int buyCount(int type, Member loginMember) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.fundingBuy";
		else		  mapperId = "reviewMapper.donationBuy";
		return sqlSession.selectOne(mapperId, loginMember);
	}


	/** 리뷰 상세조회 DAO
	 * @param rBoardNo
	 * @return fReviewView/dReviewView
	 */
	public Review selectReviewView(int type, int rBoardNo) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.fReviewView";
		else	  	  mapperId = "reviewMapper.dReviewView";
		return sqlSession.selectOne(mapperId, rBoardNo);
	}


	/** 글작성 페이지에 불러올 프로젝트 이미지, 제목 조회 DAO
	 * @param type
	 * @return
	 */
	public List<Review> selectInfo(int type, Member loginMember) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.fInfoSelect";
		else	  	  mapperId = "reviewMapper.dInfoSelect";
		return sqlSession.selectList(mapperId, loginMember);
	}


	/** 게시글 작성 DAO
	 * @param review
	 * @param images
	 * @param savePath
	 * @return result
	 */
	public int insertReview(int type, Review review) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.insertFundingReview";
		else		  mapperId = "reviewMapper.insertDonationReview";
		return sqlSession.insert(mapperId, review);
	}

	
	/** 시퀀스 얻어오기 DAO
	 * @return reviewNo
	 */
	public int selectNextNo(int type) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.selectNextFNo";
		else		  mapperId = "reviewMapper.selectNextDNo";
		return sqlSession.selectOne(mapperId);
	}


	/** 게시글 이미지 삽입
	 * @param at
	 * @return result
	 */
	public int insertImages(int type, Attachment at) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.insertFundingImages";
		else		  mapperId = "reviewMapper.insertDonationImages";
		return sqlSession.insert(mapperId, at);
	}


	/**  파일 저장 오류 시 DB에 저장된 내용 삭제 DAO
	 * @param type
	 * @param reviewNo
	 */
	public void deleteAttachment(int type, int reviewNo) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.deleteFundingImages";
		else		  mapperId = "reviewMapper.deleteDonationImages";
		sqlSession.delete(mapperId, reviewNo);
	}


	/** 게시글 상세 조회시 이미지 조회 DAO
	 * @param type
	 * @param rBoardNo
	 * @return files
	 */
	public List<Attachment> selectFiles(int type, int rBoardNo) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.selectFundingImages";
		else		  mapperId = "reviewMapper.selectDonationImages";
		return sqlSession.selectList(mapperId, rBoardNo);
	}


	/** 리뷰 글 삭제 DAO
	 * @param type
	 * @param reviewNo
	 * @return result
	 */
	public int deleteReview(int type, int reviewNo) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.deleteFundingReview";
		else		  mapperId = "reviewMapper.deleteDonationReview";
		return sqlSession.delete(mapperId, reviewNo);
	}

 
	/** 특정 번호의 (펀딩,기부)프로젝트 정보 조회 DAO
	 * @param type
	 * @param review
	 * @return fInfo, dInfo
	 */
	public Review selectInfoOne(int type, Review review) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.fundingOneInfo";
		else		  mapperId = "reviewMapper.donationOneInfo";
		return sqlSession.selectOne(mapperId, review);
	}


	/** 리뷰 수정 DAO
	 * @param review
	 * @return result
	 */
	public int updateReview(int type, Review review) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.updateFundingReview";
		else		  mapperId = "reviewMapper.updateDonationReview";
		return sqlSession.update(mapperId, review);
	}


	/** 수정시 이미지 업데이트 DAO
	 * @param at
	 * @return result
	 */
	public int updateAttachment(int type, Attachment at) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.updateFundingImages";
		else		  mapperId = "reviewMapper.updateDonationImages";
		return sqlSession.update(mapperId, at);
	}


	/** 수정시 기존 이미지 삭제 DAO
	 * @param fileNo
	 * @return result
	 */
	public int deleteAttachment2(int type, int fileNo) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.deleteFundingImages2";
		else		  mapperId = "reviewMapper.deleteDonationImages2";
		return sqlSession.delete(mapperId, fileNo);
	}

	
	/** 조회수 증가 DAO
	 * @param type
	 * @param rBoardNo
	 * @return result
	 */
	public int increaseCount(int type, int rBoardNo) {
		String mapperId = null;
		if(type == 1) mapperId = "reviewMapper.increaseCountF";
		else		  mapperId = "reviewMapper.increaseCountD";
		return sqlSession.delete(mapperId, rBoardNo);
	}


	/** 기부 top5 랭킹 조회 DAO
	 * @return list2
	 */
	public List<Donation> selectTopViewsD() {
		return sqlSession.selectList("donationMapper.selectTopViews");
	}


	/** 펀딩 top5 랭킹 조회 DAO
	 * @return list1
	 */
	public List<FundingProject> selectTopViewsF() {
		return sqlSession.selectList("reviewMapper.selectTopViews");
	}



	
	
}
