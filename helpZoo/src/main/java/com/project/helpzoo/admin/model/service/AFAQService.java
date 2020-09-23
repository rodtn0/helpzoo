package com.project.helpzoo.admin.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.Board;

public interface AFAQService {

	List<Board> selectFaqList(int type);

	int deleteFaq(String fAQNo);

}
