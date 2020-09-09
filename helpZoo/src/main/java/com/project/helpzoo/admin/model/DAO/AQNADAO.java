package com.project.helpzoo.admin.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.admin.model.vo.QNABoard;

@Repository
public class AQNADAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 목록 조회
	 * @return
	 */
	public List<QNABoard> selectList() {
		return sqlSession.selectList("qnaMapper.QuestionList", null);
	}

	/** 답변 유무 
	 * @param qnaNo
	 * @return
	 */
	public int selectAnswer(int qnaNo) {
		return sqlSession.selectOne("qnaMapper.selectAnswer", qnaNo);
	}

	/** 상세 조회
	 * @param boardNo
	 * @return
	 */
	public QNABoard selectBoard(int boardNo) {
		return sqlSession.selectOne("qnaMapper.selectBoard", boardNo);
	}

}
