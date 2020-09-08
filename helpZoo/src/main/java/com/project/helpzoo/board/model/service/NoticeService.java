package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.Board;

public interface NoticeService {

	/** 공지사항 목록 조회 service
	 * @param type
	 * @return noticeList
	 */
	public abstract List<Board> selectList(int type);

	/** 공지사항 상세 조회
	 * @param boardNo
	 * @return board
	 */
	public abstract Board selectNotice(int boardNo);

}
