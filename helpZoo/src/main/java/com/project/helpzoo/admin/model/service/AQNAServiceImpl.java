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

	@Override
	public int selectAnswer(int qnaNo) {
		return qnaDAO.selectAnswer(qnaNo);
	}

	@Override
	public QNABoard selectBoard(int boardNo) {
		return qnaDAO.selectBoard(boardNo);
	}

}
