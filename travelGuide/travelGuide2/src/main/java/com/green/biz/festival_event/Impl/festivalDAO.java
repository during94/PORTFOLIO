package com.green.biz.festival_event.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.festival_event.festivalService;
import com.green.biz.festival_event.festivalVO;

@Repository
public class festivalDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insert_festival(festivalVO vo) {
		mybatis.insert("festivalDAO.insert_festival",vo);
	}
	
	public List<festivalVO> festival_list(festivalVO vo) {
		
		return mybatis.selectList("festivalDAO.festival_list",vo);
		
	}
	
	public festivalVO get_festival(festivalVO vo) {
		return mybatis.selectOne("festivalDAO.get_festival",vo);
	}
	
	public void update_festival(festivalVO vo) {
		mybatis.update("festivalDAO.update_festival", vo);
	}
	
	public void delete_festival(festivalVO vo) {
		mybatis.update("festivalDAO.delete_festival", vo);
	}
}
