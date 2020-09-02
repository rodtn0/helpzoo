package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.board.model.DAO.NoticeDAO;
import com.project.helpzoo.board.model.vo.Board;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	// 공지사항 목록 조회 service 구현
	@Override
	public List<Board> selectList(int type) {
		return noticeDAO.selectList(type);
	}

	
	
}
