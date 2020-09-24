package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.admin.model.DAO.ABoardDAO;
import com.project.helpzoo.board.model.vo.Board;

@Service
public class ABoardServiceImpl implements ABoardService{

	@Autowired
	private ABoardDAO aBoardDAO;

	// 공지사항 관리 페이지 리스트 ------------------------------------------------------
	@Override
	public List<Board> noticeList() {
		return aBoardDAO.noticeList();
	}

	// 이벤트 관리 페이지 리스트 ------------------------------------------------------
	@Override
	public List<Board> eventList() {
		return aBoardDAO.eventList();
	}

	// 공지사항 게시물 상태 확인 ------------------------------------------------------
	@Override
	public int confirmNotice(int boardNo) {
		return aBoardDAO.confirmNotice(boardNo);
	}

	// 공지사항 게시물 삭제 ----------------------------------------------------------
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int delNotice(int boardNo) {
		return aBoardDAO.delNotice(boardNo);
	}

	// 이벤트 게시물 상태 확인 ------------------------------------------------------
	@Override
	public int confirmEvent(int boardNo) {
		return aBoardDAO.confirmEvent(boardNo);
	}

	// 이벤트 게시물 삭제 ----------------------------------------------------------
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int delEvent(int boardNo) {
		return aBoardDAO.delEvent(boardNo);
	}
	
}
