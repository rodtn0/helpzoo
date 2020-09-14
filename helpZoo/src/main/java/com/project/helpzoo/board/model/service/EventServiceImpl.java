package com.project.helpzoo.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.board.model.DAO.EventDAO;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Search;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private PageInfo pInfo;
	
	// 페이징 처리용 service 구현 ------------------------------------------------------
	@Override
	public PageInfo pagination(int type, int cp) {
		
		int listCount = eventDAO.getListCount(type);
		
		pInfo.setPageInfo(cp, listCount, type);
		
		System.out.println("pInfo : " + pInfo);
		
		return pInfo;
	}

	// 이벤트 목록 조회 service 구현 ----------------------------------------------------
	@Override
	public List<Board> selectList(PageInfo pInfo) {
		return eventDAO.selectList(pInfo);
	}
	
	// 공지사항 상세 조회 ------------------------------------------------------------
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Board selectEvent(int boardNo) {
		
		// 공지사항 글 조회
		Board board = eventDAO.selectEvent(boardNo);
		
		// 조회시 값이 있으면 조회수 증가
		if(board != null) {
			int result = eventDAO.increaseCount(boardNo);
			
			// 조회된 공지사항의 조회수를 1 증가시킴(DB와 일치시킴)
			if(result > 0) {
				board.setReadCount(board.getReadCount() + 1);
			}
			
		}
		
		return board;
	}
	
	// 공지사항 글 등록 service ---------------------------------------------------------------
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertEvent(Board board) {
		
		int result = 0;
		
		// board의 시퀀스 얻어오기
		int boardNo = eventDAO.selectNextNo();
		
		if(boardNo > 0) {
			// 얻어온 board 시퀀스 값 board객체에 세팅
			board.setBoardNo(boardNo);
			
			// xss 방지 처리
			board.setBoardTitle(replaceParameter(board.getBoardTitle()));
			board.setBoardContent(replaceParameter(board.getBoardContent()));
			
			// 공지사항 DB에 등록
			result = eventDAO.insertEvent(board);
		}
		
		return result;
	}
    
    // 공지사항 글 삭제 service -------------------------------------------------------------
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteEvent(int boardNo) {
		
		return eventDAO.deleteEvent(boardNo);
	}
	
	// 공지사항 글 수정 service 구현 ---------------------------------------------------------
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateEvent(Board uBoard) {
		
		// xss 방지 처리
		uBoard.setBoardTitle(replaceParameter(uBoard.getBoardTitle()));
		uBoard.setBoardContent(replaceParameter(uBoard.getBoardContent()));
		
		int result = eventDAO.updateEvent(uBoard);
		
		return result;
	}
	
	// XSS 방지 메소드 service -------------------------------------------------------------
	public String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
	}

	// 검색 조건 추가된 페이지 처리 service 구현 ---------------------------------------------------
	@Override
	public PageInfo pagination(int type, int cp, Search search) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("type", type);
		
		System.out.println("map : " + map);
		
		int searchListCount = eventDAO.getSearchListCount(map);

		pInfo.setPageInfo(cp, searchListCount, type);
		
		return pInfo;
	}

	// 검색 목록 조회 service 구현 ----------------------------------------------------------
	@Override
	public List<Board> selectSearchList(PageInfo pInfo, Search search) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("type", pInfo.getBoardType());
		
		return eventDAO.selectSearchList(pInfo, map);
	}
	
	
	
}
