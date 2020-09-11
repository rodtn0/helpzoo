package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.admin.model.DAO.AQNADAO;
import com.project.helpzoo.admin.model.vo.QNABoard;

@Service
public class AQNAServiceImpl implements AQNAService{
	
	@Autowired
	public AQNADAO qnaDAO;
	
	/**
	 * qna Question 목록 가져오기
	 */
	@Override
	public List<QNABoard> selectList() {
		
		return qnaDAO.selectList();
	}

	/**
	 * 답변 유무
	 */
	@Override
	public int selectAnswer(int qnaNo) {
		return qnaDAO.selectAnswer(qnaNo);
	}

	/**
	 * Question 상세보기
	 */
	@Override
	public QNABoard selectBoard(int qnaNo) {
		return qnaDAO.selectBoard(qnaNo);
	}

	/**
	 * Answer 목록 조회
	 */
	@Override
	public QNABoard selectAnswerBoard(int qnaNo) {
		return qnaDAO.selectAnswerBoard(qnaNo);
	}

	/**
	 * 답변 Answer 작성
	 */
	@Override
	public int insertAnswer(QNABoard qnaBoard) {
		return qnaDAO.insertAnswer(qnaBoard);
	}

	/**
	 * 답변 보낼 이메일 가져오기
	 */
	@Override
	public String selectEmail(String writer) {
		// TODO Auto-generated method stub
		return qnaDAO.selectEmail(writer);
	}

}
