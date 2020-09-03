package com.project.helpzoo.funding.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.funding.model.vo.Order;


public class JpaMain {

	public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("helpzoo");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    
		
		

	}
	

    public static void logic(EntityManager em) {

        
        Order order = new Order();
        
        order.setId(2L);

        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

        order.setDeliveryId(1L);
        order.setDeliveryId2(2L);
        
        order.setOrderDate(sqlDate);
        
        order.setStatus("N");
  
        
        //등록
        em.persist(order);
        

        //한 건 조회
        Order findOrder = em.find(Order.class, 2L);
        System.out.println("findMember=" + findOrder.getDeliveryId() + ", age=" + findOrder.getOrderDate());

        //목록 조회
        List<Order> orders = em.createQuery("select o from Order o", Order.class).getResultList();
        System.out.println("members.size=" + orders.size());

        //삭제
       

    }

}
