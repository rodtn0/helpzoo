package com.project.helpzoo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.model.vo.DReply;



@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 댓글 조회
	 * @param boardNo
	 * @return
	 */
	public List<DReply> selectList(int boardNo) {

		return sqlSession.selectList("donationMapper.selectList", boardNo);
	}

	/** 댓글 삽입
	 * @param reply
	 * @return
	 */
	public int insertRelpy(DReply reply) {

		return sqlSession.insert("donationMapper.insertRelpy", reply);
	}

	/** 답글 삽입
	 * @param reply
	 * @return
	 */
	public int insertRelpy2(DReply reply) {

		return sqlSession.insert("donationMapper.insertRelpy2", reply);
	}

	/** 댓글 수정
	 * @param reply
	 * @return
	 */
	public int updateReply(DReply reply) {

		return sqlSession.insert("donationMapper.updateReply", reply);
	}


}
