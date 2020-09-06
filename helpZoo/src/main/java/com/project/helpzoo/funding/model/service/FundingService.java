package com.project.helpzoo.funding.model.service;

import java.util.List;

import com.project.helpzoo.funding.model.vo.FundingProject;

public interface FundingService {

	List<FundingProject> selectList(int cp);

}
