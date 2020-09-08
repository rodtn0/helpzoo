package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.QNABoard;

public interface QNAService {

	// qna 페이징
	public abstract PageInfo pagination(int cp);

	// qna 목록 조회
	public abstract List<QNABoard> selectList(PageInfo pInfo);
	
	// qna 작성
	public abstract int insertBoard(QNABoard qnaBoard, String savePath,
			List<MultipartFile> images);

	// qna 질문 쓴 memberId 가져오기
	public abstract String selectQuestionId(int qnaNo);

}
