package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.vo.Attachment;
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
	
	// qna 상세 조회
	public abstract QNABoard selectBoard(int qnaNo);

	// qna 상세조회 파일 가져오기
	public abstract List<Attachment> selectFiles(int qnaNo);

	// qna 질문 쓴 memberId 가져오기
	public abstract String selectQuestionId(int qnaNo);

	// qna 수정
	public abstract int updateBoard(QNABoard upqnaBoard, String savePath, List<MultipartFile> images, boolean[] deleteImages);

	// qna 삭제
	public abstract int deleteBoard(int qnaNo);

	/** 검색 조건이 추가된 페이징 처리 Service
	 * @param cp
	 * @param id
	 * @return
	 */
	public abstract PageInfo pagination(int cp, String id);

	/** 검색 조건이 추가된 목록 조회
	 * @param pInfo
	 * @param id
	 * @return
	 */
	public abstract List<QNABoard> selectSearchList(String id);

}
