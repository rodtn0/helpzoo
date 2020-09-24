package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.admin.model.DAO.AFAQDAO;
import com.project.helpzoo.board.model.vo.Board;

@Service
public class AFAQServiceImpl implements AFAQService{

	
	@Autowired
	private AFAQDAO fDao;
	@Override
	public List<Board> selectFaqList(int type) {
		return fDao.selectFaqList(type);
	}
	@Override
	public int deleteFaq(String fAQNo) {
		return fDao.deleteFaq(fAQNo);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertBoard(Board board) {
		
		int result = 0;
		
		int boardNo = fDao.selectNextNo();
		
		if(boardNo > 0) {
			board.setBoardNo(boardNo);
			System.out.println("Service" + board);
			
			board.setBoardContent(replaceParameter(board.getBoardContent()));
			
			result = fDao.insertFaq(board);
		}
		
		return result;
	}
	
    // 크로스 사이트 스크립트 방지 메소드
    private String replaceParameter(String param) {
    	String result = param;
    	if(param != null) {
    		result = result.replaceAll("&", "&amp;");
    		result = result.replaceAll("<", "&lt;");
    		result = result.replaceAll(">", "&gt;");
    		result = result.replaceAll("\"", "&quot;");
    	}
    	
    	return result;
    }

}
