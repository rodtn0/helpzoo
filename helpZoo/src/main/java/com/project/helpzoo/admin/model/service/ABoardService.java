package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.helpzoo.admin.model.DAO.ABoardDAO;
import com.project.helpzoo.board.model.vo.Board;

public interface ABoardService {

	/** 공지사항 관리 페이지 리스트
	 * @return noticeList
	 */
	public abstract List<Board> noticeList();

	/** 이벤트 관리 페이지 리스트
	 * @return eventList
	 */
	public abstract List<Board> eventList();

}
