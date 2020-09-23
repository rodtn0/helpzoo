package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.admin.model.DAO.ADonationDAO;
import com.project.helpzoo.model.vo.Donation2;

@Service
public class ADonationImpl implements ADonationService{

	
	@Autowired
	public ADonationDAO donationDAO;
	
	@Override
	public List<Donation2> selectList() {
		return donationDAO.selectList();
	}

	@Override
	public int deleteDonation(String donationNo) {
		return donationDAO.deleteDonation(donationNo);
	}

}
