package com.project.helpzoo.admin.model.service;

import java.util.List;

import com.project.helpzoo.model.vo.Donation2;

public interface ADonationService {

	List<Donation2> selectList();

	int deleteDonation(String donationNo);

}
