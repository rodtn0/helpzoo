package com.project.helpzoo.admin.model.service;

import java.util.List;

import com.project.helpzoo.admin.model.vo.QNABoard;

public interface AQNAService {

	// 목록 가져오기
	public abstract List<QNABoard> selectList();

	// 답변 여부 유무 가져오기
	public abstract int selectAnswer(int qnaNo);

	// 상세 조회 
	public abstract QNABoard selectBoard(int qnaNo);
	
	// 답변 목록 조회
	public abstract QNABoard selectAnswerBoard(int qnaNo);

	// 답변 작성
	public abstract int insertAnswer(QNABoard qnaBoard);

	// 질문한 사람 이메일 가져오기
	public abstract String selectEmail(String writer);

}
