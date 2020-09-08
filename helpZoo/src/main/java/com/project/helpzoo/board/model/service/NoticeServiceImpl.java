package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.board.model.DAO.NoticeDAO;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private PageInfo pInfo; 
	
	// 페이징 처리용 service 구현
	@Override
	public PageInfo pagination(int type, int cp) {
		
		int listCount = noticeDAO.getListCount(type);
		
		pInfo.setPageInfo(cp, listCount, type);
		
		System.out.println("pInfo : " + pInfo);
		
		return pInfo;
	}
	
	// 공지사항 목록 조회 service 구현
	@Override
	public List<Board> selectList(PageInfo pInfo) {
		return noticeDAO.selectList(pInfo);
	}

	// 공지사항 상세 조회
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Board selectNotice(int boardNo) {
		
		// 공지사항 글 조회
		Board board = noticeDAO.selectNotice(boardNo);
		
		// 조회시 값이 있으면 조회수 증가
		if(board != null) {
			int result = noticeDAO.increaseCount(boardNo);
			
			// 조회된 공지사항의 조회수를 1 증가시킴(DB와 일치시킴)
			if(result > 0) {
				board.setReadCount(board.getReadCount() + 1);
			}
			
		}
		
		return board;
	}


	
	
}
