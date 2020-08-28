package com.project.helpzoo.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.board.model.DAO.FAQDAO;
import com.project.helpzoo.board.model.vo.Board;

@Service
public class FAQServiceImpl implements FAQService{

	@Autowired FAQDAO faqDAO;
	
	@Override
	public List<Board> selectList(int type) {
		return faqDAO.selectList(type);
	}

}
