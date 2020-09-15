package com.project.helpzoo.admin.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.admin.model.vo.AFunding;

@Repository
public class AFundingDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<AFunding> selectFunding() {
		return sqlSession.selectList("adminMapper.selectFunding",null);
	}

	public int updateFunding(AFunding funding) {
		return sqlSession.update("adminMapper.updateFunding", funding);
	}

	public int deleteFunding(String fundingNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("adminMapper.deleteFunding", fundingNo);
	}

}
