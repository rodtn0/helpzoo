package com.project.helpzoo.admin.model.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ADonationDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

}
