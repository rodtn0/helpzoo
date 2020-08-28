package com.project.helpzoo.board.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Board;

@Repository
public class FAQDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Board> selectList(int type) {
		return sqlSession.selectList("faqMapper.selectFAQ", type);
	}
}
