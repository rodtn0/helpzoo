package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
