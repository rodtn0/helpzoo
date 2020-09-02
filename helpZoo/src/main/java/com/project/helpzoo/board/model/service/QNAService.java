package com.project.helpzoo.board.model.service;

import java.util.List;

import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.QNABoard;

public interface QNAService {

	public abstract PageInfo pagination(int cp);

	public abstract List<QNABoard> selectList(PageInfo pInfo);

}
