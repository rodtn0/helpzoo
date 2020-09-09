package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;

public interface NoticeService {

	/** 공지사항 목록 조회 service
	 * @param type
	 * @return noticeList
	 */
	public abstract List<Board> selectList(PageInfo pInfo);

	/** 공지사항 상세 조회
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

	/** 공지사항 글 등록
	 * @param board
	 * @return result
	 */
	public abstract int insertNotice(Board board);

}
