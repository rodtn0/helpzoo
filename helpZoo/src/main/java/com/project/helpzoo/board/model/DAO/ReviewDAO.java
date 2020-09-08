package com.project.helpzoo.board.model.DAO;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;

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
		
		if(pInfo.getBoardType() == 1) mapperId = "reviewMapper.selectFundingList";
		else		  				  mapperId = "reviewMapper.selectDonationList";
		
		return sqlSession.selectList(mapperId, rowBounds);
	}

	
	
}
