package com.project.helpzoo.admin.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.admin.model.vo.AFunding;
import com.project.helpzoo.admin.model.vo.AFundingCategory;

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

	public List<AFunding> selectFSList(String listStatus) {
		return sqlSession.selectList("adminMapper.selectFSList", listStatus);
	}

	public List<AFunding> selectMonthFee(String yy) {
		return sqlSession.selectList("adminMapper.selectMonthFee", yy);
	}

	public List<AFundingCategory> selectCategory(String yymm) {
		return sqlSession.selectList("adminMapper.selectCategory", yymm);
	}

	public List<AFunding> selectSuccess(String yymm) {
		return sqlSession.selectList("adminMapper.selectSuccess", yymm);
	}

	public List<AFunding> selectTopViews() {
		return sqlSession.selectList("adminMapper.selectTopViews", null);
	}

	public List<AFunding> selectEndTop() {
		return sqlSession.selectList("adminMapper.selectEndTop", null);
	}

}
