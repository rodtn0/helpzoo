package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.board.model.DAO.QNADAO;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.QNABoard;

@Service
public class QNAServiceImpl implements QNAService{

	@Autowired
	private QNADAO qnaDAO;
	
	@Autowired
	private PageInfo pInfo;
	
	@Override
	public PageInfo pagination(int cp) {
		
		// 전체 게시글 수 조회
		int listCount = qnaDAO.getListCount(cp);
		
		pInfo.setPageInfo(cp, listCount);
		
		return pInfo;
	}

	@Override
	public List<QNABoard> selectList(PageInfo pInfo) {
		return qnaDAO.selectList(pInfo);
	}

}
