package com.green.biz.UserContent.Impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.UserContent.UserContentVO;
import com.green.biz.util.Criteria;
import com.green.biz.util.SearchCriteria;

@Repository
public class UserContentDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<UserContentVO> AreaList(UserContentVO vo, SearchCriteria scri) {
		
		HashMap<Object, Object> map = new HashMap<>();
		map.put("num", vo);
		map.put("scri", scri);
		
		return mybatis.selectList("userContentDAO.Areapaging", map);
	}
	
	public List<UserContentVO> topList(UserContentVO vo) {
		
		return mybatis.selectList("userContentDAO.topList", vo);
	}
	
	public List<UserContentVO> getUserContentList(SearchCriteria scri) {
		
		return mybatis.selectList("userContentDAO.listPage", scri);
	}
	
	public int listCount(SearchCriteria scri) {
		return mybatis.selectOne("userContentDAO.listCount", scri);
	}
	
	public void insertContent(UserContentVO vo) {
		
		mybatis.insert("userContentDAO.insertContent", vo);
	}
	
	public UserContentVO detailContent(UserContentVO vo) {
		return mybatis.selectOne("userContentDAO.detailContent", vo);
	}
	
	public void detail_update(UserContentVO vo) {
		mybatis.update("userContentDAO.detail_update", vo);
	}
	
	public void delete_content(UserContentVO vo) {
		mybatis.delete("userContentDAO.delete_content", vo);
	}
	
	public void c_count_up(UserContentVO vo) {
		mybatis.update("userContentDAO.c_count_up", vo);
	}
	
	public List<UserContentVO> getSearch_list(UserContentVO vo) {
		return mybatis.selectOne("userContentDAO.find_kind", vo);
	}
}
