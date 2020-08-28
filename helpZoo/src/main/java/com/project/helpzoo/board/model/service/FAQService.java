package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.Board;

public interface FAQService {

	List<Board> selectList(int type);

}
