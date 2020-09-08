package com.project.helpzoo.funding.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.project.helpzoo.funding.model.vo.FundingProject;

@Repository
public class FundingDAO {

	@PersistenceContext
    EntityManager em ; 
	 
	 
	public List<FundingProject> selectList(int cp) {
	
		TypedQuery<FundingProject> query = 
				em.createQuery("SELECT f FROM FundingProject f ORDER BY f.id",FundingProject.class);
		
		query.setFirstResult(cp);
		query.setMaxResults(cp+9);
		
		return query.getResultList();
	}

	
	
	
}
