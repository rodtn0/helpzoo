package com.project.helpzoo.funding.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.helpzoo.funding.controller.FundingController;

@Component
public class FundingScheduling {

	
	@Autowired
	private FundingController controller;
	
	
	
	@Scheduled(cron = "0 0 0 * * *") //매일 0분 0시에
	public void test() {
		
		
		
	}
	
	
	
	
}
