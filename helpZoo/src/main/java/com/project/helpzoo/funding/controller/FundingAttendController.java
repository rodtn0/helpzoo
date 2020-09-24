package com.project.helpzoo.funding.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.project.helpzoo.funding.dto.viewDetail.OrderRewardView;
import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.service.FundingService;
import com.project.helpzoo.funding.model.vo.KakaoPayApiItem;
import com.project.helpzoo.funding.model.vo.funding.Reward;
import com.project.helpzoo.funding.model.vo.order.Address;
import com.project.helpzoo.funding.model.vo.order.Delivery;
import com.project.helpzoo.funding.model.vo.order.DeliveryStatus;
import com.project.helpzoo.funding.model.vo.order.OrderReward;
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
		public String fundingPay(@PathVariable int fundingNo,Model model, OrderRewardView orderReward) {
			
			
			Long fundingNo2 = ((Integer)fundingNo).longValue();
			
			
			
			
			
			model.addAttribute("orderReward", orderReward);
			
			model.addAttribute("fundingNo", fundingNo2);
			
			
			System.out.println(orderReward + "페이 펀딩리와드");
			
			return "funding/fundingPayment";
			
			
		}
		
		
		@PostMapping("/kakaoPay")
	    public String kakaoPay(Model model,OrderRewardView orderReward, Long fundingNo ) {
				
			
			
			
			/*
			 * String[] ooid2 = (String[])model.getAttribute("id");
			 * 
			 * String[] ooamount2 = (String[])model.getAttribute("amount");
			 * 
			 * int[] ooid = new int [ooid2.length];
			 * 
			 * int[] ooamount = new int [ooamount2.length];
			 * 
			 * 
			 * for(int i = 0; i<ooid2.length; i++) {
			 * 
			 * ooid[i] = Integer.parseInt(ooid2[i]);
			 * 
			 * ooamount[i] = Integer.parseInt(ooamount2[i]);
			 * 
			 * 
			 * 
			 * 
			 * }
			/*
			 * orderReward.setAmount(ooamount); orderReward.setId(ooid);
			 */
			
			System.out.println(orderReward + "카카오 페이 펀딩리와드");
			

			Member member = (Member)model.getAttribute("loginMember");
			
			
			
			
			 LocalDateTime localDateTime = LocalDateTime.now();
			
			 Timestamp timestamp2 = Timestamp.valueOf(localDateTime);
			 
			 
			 String address = member.getMemberAddress();
			 
			 StringTokenizer add = new StringTokenizer(address, ",");
			 
			 
			 String addr[] 	= new String[3];
			 	
			 int d= 0;
					   while(add.hasMoreTokens()) { 
			               
						   addr[d++] = add.nextToken();
						   
			            }
					   
		  Address addressObject = new Address(addr[0], addr[1], addr[2]);
			 
		  System.out.println(addressObject);
					   
			
		
		
			
			
			
			Orders order = new Orders(timestamp2, "N", null, member.getMemberNo());
			
		
			
			System.out.println(order);
			
			Long ordersId = service.saveOrder(order, addressObject,fundingNo);
			
			
			
			
		List<OrderReward> orderRewards = service.persisOrderReward(orderReward,ordersId);
				
			
			
			
			
			int quantity = 0;
			
			int totalAmount = 0;
			
			String name = null;
			for(int i = 0; i< orderReward.getId().length; i++) {
				
			quantity +=	orderReward.getAmount()[i];
			
			totalAmount = service.getPrice(orderReward.getId()[i])  *orderReward.getAmount()[i];
			
			
			}
			
			name = service.getRewardName(orderReward.getId()[0]);
			
			
			if(quantity >=1) {
				
				name += "외" + (quantity-1) + "개";
			}
			
			
			
			
			
		  KakaoPayApiItem item = new KakaoPayApiItem(name, quantity, member.getMemberId(), ordersId, totalAmount);
	        
		  
		  String url = service.kakaoPayReady(item);
					
		 
		  if(url.equals("kakaoPaysuccess")) {
			  
			  service.permitOrder(ordersId);
			  
		  }
		
		
		  return "redirect:" + url;
	 
			
	    }
	    
		
		  @GetMapping("/kakaoPaySuccess")
		    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
		   
		        
		        model.addAttribute("info", service.kakaoPayInfo(pg_token));
		        
		    }
		
		
		
		
		
		
		
		
		
		
}
