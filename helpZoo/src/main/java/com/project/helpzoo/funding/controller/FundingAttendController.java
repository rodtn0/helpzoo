package com.project.helpzoo.funding.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.viewDetail.FundingDetailRewardView;
import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.service.FundingService;
import com.project.helpzoo.funding.model.vo.KakaoPayApiItem;
import com.project.helpzoo.funding.model.vo.order.Address;
import com.project.helpzoo.funding.model.vo.order.Delivery;
import com.project.helpzoo.funding.model.vo.order.DeliveryStatus;
import com.project.helpzoo.funding.model.vo.order.Orders;
import com.project.helpzoo.member.model.vo.Member;


	
	

	@Controller
	@SessionAttributes({"loginMember"})
	@RequestMapping("/fundingAttend/*")
	public class FundingAttendController {

		
		@Autowired
		private FundingService service;
		
		private FundingDAO dao;
		
		
		@RequestMapping("rewardChoice/{fundingNo}")
		public String fundingView(@PathVariable int fundingNo, Model model) {
			

			Long fundingNo2 = ((Integer)fundingNo).longValue();
			
			
			
			List<FundingDetailRewardView> rewardList = service.selectReward(fundingNo2);
			
			
			model.addAttribute("rewardList", rewardList);
			
			return "funding/fundingAttend";
			
			
		}
		
		
		@RequestMapping("pay/{fundingNo}")
		public String fundingPay(@PathVariable int fundingNo, int finalAmount ,Model model) {
			

			Long fundingNo2 = ((Integer)fundingNo).longValue();
			
			
			
			List<FundingDetailRewardView> rewardList = service.selectReward(fundingNo2);
			
			
			model.addAttribute("rewardList", rewardList);
			
			return "funding/fundingPayment";
			
			
		}
		
		
		@PostMapping("/kakaoPay")
	    public String kakaoPay(Model model) {
				
			Member member = (Member)model.getAttribute("loginMember");
			
			
			
			 LocalDateTime localDateTime = LocalDateTime.now();
			
			 Timestamp timestamp2 = Timestamp.valueOf(localDateTime);
			 
			 
			 String address = member.getMemberAddress();
			 
			 StringTokenizer add = new StringTokenizer(address);
			 
			 
			 String addr[] 	= null;
			 	
			 int i = 0;
					   while(add.hasMoreTokens()) { 
			               
						   addr[i] = add.nextToken();
			            }
					   
		  Address addressObject = new Address(addr[0], addr[1], addr[2]);
			 
					   
			
			Delivery delivery = new Delivery(new Orders(),addressObject , DeliveryStatus.READY);
			 
			 
			
			
			
			
			
			
		//	Orders order = new Orders(timestamp2, "N", delivery, member.getMemberId(), orderRewards)
			
			
					
					
					
			Long orderId = service.makerOrder();
			
			
			
			
			
		//	KakaoPayApiItem item = new KakaoPayApiItem(name, quantity, member.getMemberId(), orderId, totalAmount)
	        
					
					
	//		  return "redirect:" + service.kakaoPayReady(item);
	 
			
			return "dd";
	    }
	    
	    @GetMapping("/kakaoPaySuccess")
	    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
	 
	        System.out.println("kakaoPaySuccess pg_token : " + pg_token);
	        
	    }
		
		
		
		
		
		
		
		
		
		
}
