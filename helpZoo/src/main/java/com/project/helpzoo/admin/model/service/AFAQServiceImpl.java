package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
