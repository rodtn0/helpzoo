package com.project.helpzoo.board.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Review;

@Repository
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 펀딩 후기 게시판 목록 조회DAO
	 * @param type
	 * @return fList
	 */
	public List<Review> selectFundingList(int type) {
		return sqlSession.selectList("reviewMapper.selectFundingList", type);
	}

}
