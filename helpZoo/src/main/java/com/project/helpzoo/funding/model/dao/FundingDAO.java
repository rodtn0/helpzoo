package com.project.helpzoo.funding.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.project.helpzoo.funding.model.vo.funding.FundingCategory;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.funding.QFundingCategory;
import com.project.helpzoo.funding.model.vo.funding.QFundingMaker;
import com.project.helpzoo.funding.model.vo.funding.QFundingProject;
import com.project.helpzoo.funding.model.vo.order.Orders;
import com.project.helpzoo.funding.model.vo.order.QOrderReward;
import com.project.helpzoo.funding.model.vo.order.QReward;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
@Transactional
public class FundingDAO {

	@PersistenceContext
	private EntityManager em;

	public List<FundingProject> selectList(int cp, FundingSearch fundingSearch) {

		
		  JPAQueryFactory query = new JPAQueryFactory(em);
		  
		  QFundingProject funding = QFundingProject.fundingProject;
		  
		  QFundingCategory category = QFundingCategory.fundingCategory;
		  
		  QFundingMaker maker = QFundingMaker.fundingMaker;
		  
		  QReward reward = QReward.reward;
		  
		  QOrderReward orderReward = QOrderReward.orderReward;
		  
		  
		  
		
		  List <Tuple> result =query
		  .select(funding.title,category.category_name,maker.name,
				  funding.goalAmount,reward.price, orderReward.count.sum())
		  .from(funding)
		  .leftJoin(funding.reward, reward) 
		  .leftJoin(orderReward).on(reward.id.eq(orderReward.reward.id)) 
		  .leftJoin(funding.category,category)
		  .leftJoin(funding.fundingMaker, maker)
		  .where(funding.id.eq(1L)) 
		  .groupBy(funding.title,category.category_name,maker.name, funding.goalAmount,reward.price)
		  .offset(0)
		  .limit(10)
		  .fetch();
		  
		  
		  
		 for(Tuple tuple : result) { 
			System.out.println("name =  " +tuple.get(funding.title)); 
			System.out.println("name =  " +tuple.get(orderReward.count.sum())); 
			System.out.println("name =  " +tuple.get(reward.price));
		  }
		 

		return null;
	}

	
	
	

	public List<FundingProject> fundingStatusChange() {

		return em.createQuery("select f from FundingProject f where ", FundingProject.class).getResultList();

	}

}
