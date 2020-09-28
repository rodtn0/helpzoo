package com.project.helpzoo.funding.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@SessionAttributes({"loginMember" , "orderId"})
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
			
		 RewardView reward = new RewardView();
		 List<RewardView> rewardList = new ArrayList<RewardView>();
		
		 int totalAmount = 0;
			for(int i = 0; i<orderReward.getPrice().length; i++) {
				
				reward.setTitle(orderReward.getTitle()[i]);
				reward.setPrice(orderReward.getPrice()[i]);
				reward.setAmount(orderReward.getAmount()[i]);
				
				
				totalAmount += orderReward.getPrice()[i];
				
				rewardList.add(reward);
			}
			
			
			
			orderReward.setTotalAmount(totalAmount);
			
			
			
			model.addAttribute("orderReward", orderReward);
			
			
			
			model.addAttribute("rewardList",rewardList);
			
			
			
			
			
			model.addAttribute("fundingNo", fundingNo2);
			
			
			
			
			
			
			return "funding/fundingPayment";
			
			
		}
		
		
		
		
		
		
		
		@PostMapping("/kakaoPay")
	    public String kakaoPay(Model model,OrderRewardView orderReward, int fundingNo, HttpServletRequest request ) {
				
			Long fundingNo2 = ((Integer)fundingNo).longValue();
			
			System.out.println(fundingNo + "펀딩넘버");
			
		
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
			 
	
		
		
			
			
			
			Orders order = new Orders(timestamp2, "Y", null, member.getMemberNo());
			
		 
			
			
			Long ordersId = service.saveOrder(order, addressObject,fundingNo2);
			
			
			
			
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
		  
		  
	        
		  int ooderId = ordersId.intValue();
		  
		  
		  HttpSession session = request.getSession();
		  
		  
		  
		  model.addAttribute("orderId", ooderId);
		  
		  
		  
		  String ContextPath = request.getContextPath();
		  
		  
		  
		  String url = service.kakaoPayReady(item,ContextPath,ooderId);
		
		  

		  
		  
		
		
		  return "redirect:" + url;
	 
			
	    }
	    
					  
		  	@RequestMapping("/kakaoPaySuccess/{orderId}")
		    public String kakaoPaySuccess(Model model , HttpServletRequest request , @RequestParam("pg_token") String pg_token,  @PathVariable  int orderId) {
			 
		        
		  	
		  		
		  	HttpSession session = request.getSession(false);	
		  	
		 
		  	 
		  	  
			  Long orderNo2 = ((Integer)orderId).longValue();
			  
			  Orders order = null;
			  
			 
				  order = service.findOrder(orderNo2);
				  
				  if(order.getStatus().equals("N")) {
				  return "funding/notEnoughStock";
				  }
			  
			  
			  List<OrderReward> orderRewardList = order.getOrderRewards();
		      
			  
			  int tototo = 0;
			  OrderRewardView oriView = new OrderRewardView();
			  
			  int i = 0;
			  
			  String rewardNameList[] = new String[orderRewardList.size()];
			  int[] idList = new int [orderRewardList.size()];
			  int[] amountList = new int [orderRewardList.size()];
			  int[] priceList = new int [orderRewardList.size()];
			  
			  for(OrderReward ord : orderRewardList) {
				  
				 tototo += ord.getPrice();
				 
				  rewardNameList[i] = service.findRewardName(ord.getReward().getId());
				 
				  amountList[i] = ord.getCount();
				  
				  priceList[i] = ord.getPrice().intValue();
				  
			  }
			  
			  OrderRewardView orderRewardView = new OrderRewardView();
			  
			  
			  orderRewardView.setTitle(rewardNameList);
			  
			  orderRewardView.setAmount(amountList);
			  
			  orderRewardView.setTotalAmount(tototo);
			  
			  orderRewardView.setPrice(priceList);
			  
			  
			  
			  model.addAttribute("orderRewardView", orderRewardView);
			  
			  
			  
		       return "funding/kakaoPaySuccess";
		    }
		
		
		
		
		
		
		
		
		
		
}
