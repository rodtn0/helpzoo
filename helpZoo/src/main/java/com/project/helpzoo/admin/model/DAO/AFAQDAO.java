package com.project.helpzoo.admin.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Board;

@Repository
public class AFAQDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Board> selectFaqList(int type) {
		return sqlSession.selectList("adminMapper.selectFaqList", type);
	}

}
