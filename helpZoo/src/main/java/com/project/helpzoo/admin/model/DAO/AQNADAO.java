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
	public QNABoard selectBoard(int qnaNo) {
		return sqlSession.selectOne("qnaMapper.selectQuestionBoard", qnaNo);
	}

	/** 답변 목록 조회
	 * @param qnaNo
	 * @return
	 */
	public QNABoard selectAnswerBoard(int qnaNo) {
		return sqlSession.selectOne("qnaMapper.selectAnswerBoard", qnaNo);
	}

	/** 답변 작성
	 * @param qnaNo
	 * @return
	 */
	public int insertAnswer(QNABoard qnaBoard) {
		return sqlSession.insert("qnaMapper.insertAnswer", qnaBoard);
	}

	/** 답변할 이메일 가져오기
	 * @param writer
	 * @return
	 */
	public String selectEmail(String writer) {
		return sqlSession.selectOne("qnaMapper.selectEmail", writer);
	}

}
