package com.project.helpzoo.admin.model.service;

import java.util.List;

import com.project.helpzoo.admin.model.vo.AFunding;

public interface AFundingService {

	List<AFunding> selectFunding();

	int updateFunding(AFunding funding);

	int deleteFunding(String fundingNo);

	List<AFunding> selectFSList(String listStatus);

	/* List<AFunding> selectFundingStatus(); */

}
