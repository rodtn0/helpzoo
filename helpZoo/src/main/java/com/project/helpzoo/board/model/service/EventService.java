package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Search;

public interface EventService {

	/** 페이징 처리용 service
	 * @param type
	 * @param cp
	 * @return pInfo
	 */
	public abstract PageInfo pagination(int type, int cp);

	/** 이벤트 목록 조회 service
	 * @param pInfo
	 * @return eventList
	 */
	List<Board> selectList(PageInfo pInfo);

	/** 이벤트 상세 조회 service
	 * @param boardNo
	 * @return board
	 */
	Board selectEvent(int boardNo);
	
	/** 이벤트 글 등록 service
	 * @param board
	 * @return result
	 */
	public abstract int insertEvent(Board board, List<MultipartFile> images, String savePath);

	/** 이벤트 글 삭제 service
	 * @param boardNo
	 * @return result
	 */
	public abstract int deleteEvent(int boardNo);

	/** 이벤트 글 수정 service
	 * @param uBoard
	 * @return result
	 */
	public abstract int updateEvent(Board uBoard, String savePath, List<MultipartFile> images, boolean[] deleteImages);

	/** 검색 조건 추가된 페이지 처리 service
	 * @param type
	 * @param search
	 * @return pInfo
	 */
	public abstract PageInfo pagination(int type, int cp, Search search);

	/** 검색 목록 조회 service
	 * @param pInfo
	 * @param search
	 * @return noticeList
	 */
	public abstract List<Board> selectSearchList(PageInfo pInfo, Search search);

	/** 썸네일 목록 조회 service
	 * @param eventList
	 * @return thumList
	 */
	public abstract List<Attachment> selectThumList(List<Board> eventList);

	/** 이벤트 게시글 이미지 조회 service
	 * @param boardNo
	 * @return files
	 */
	public abstract List<Attachment> selectFiles(int boardNo);

}
