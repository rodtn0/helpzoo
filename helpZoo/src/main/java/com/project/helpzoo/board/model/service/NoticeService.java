package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Search;

public interface NoticeService {

	/** 공지사항 목록 조회 service
	 * @param type
	 * @return noticeList
	 */
	public abstract List<Board> selectList(PageInfo pInfo);

	/** 공지사항 상세 조회 service
	 * @param boardNo
	 * @return board
	 */
	public abstract Board selectNotice(int boardNo);

	/** 페이징 처리용 service
	 * @param type
	 * @param cp
	 * @return pInfo
	 */
	public abstract PageInfo pagination(int type, int cp);

	/** 공지사항 글 등록 service
	 * @param board
	 * @return result
	 */
	public abstract int insertNotice(Board board);

	/** 공지사항 글 삭제 service
	 * @param boardNo
	 * @return result
	 */
	public abstract int deleteNotice(int boardNo);

	/** 공지사항 글 수정 service
	 * @param uBoard
	 * @return result
	 */
	public abstract int updateNotice(Board uBoard);

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

}
