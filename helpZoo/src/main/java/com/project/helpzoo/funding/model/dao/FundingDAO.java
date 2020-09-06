package com.project.helpzoo.funding.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.project.helpzoo.funding.model.vo.Order;
import com.project.helpzoo.funding.model.vo.funding.FundingCategory;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;




@Repository
public class FundingDAO {

	@PersistenceContext
    EntityManager em ; 
	
	
	
	
	
	
	
	
	
	
	
	public List<FundingProject> selectList(int cp, FundingSearch fundingSearch) {
	
	
		return null;
	}


	
	
	
	public List<FundingProject> fundingStatusChange() {
		
		
	return  em.createQuery("select f from  FundingProject f", FundingProject.class)
        .getResultList();
		
		
		
	}

	
	
	
}
