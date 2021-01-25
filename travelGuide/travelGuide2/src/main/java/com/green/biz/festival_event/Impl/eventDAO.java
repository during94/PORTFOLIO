package com.green.biz.festival_event.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.festival_event.eventVO;

@Repository
public class eventDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insert_event(eventVO vo) {
		mybatis.insert("eventDAO.insert_event",vo);
	}
	
	public List<eventVO> event_list(eventVO vo) {
		
		return mybatis.selectList("eventDAO.event_list",vo);
		
	}
	
	public eventVO get_event(eventVO vo) {
		return mybatis.selectOne("eventDAO.get_event",vo);
	}
	
	public void update_event(eventVO vo) {
		mybatis.update("eventDAO.update_event", vo);
	}
	
	public void delete_event(eventVO vo) {
		mybatis.update("eventDAO.delete_event", vo);
	}
}
