package com.green.biz.like.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.like.likeVO;

@Repository
public class likeDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public likeVO find_like(likeVO vo) {
		return mybatis.selectOne("userContentDAO.find_like",vo);
	}
	
	
	public void insert_like(likeVO vo) {
		mybatis.insert("userContentDAO.insert_like",vo);
	}
	
	
	public void like_up(likeVO vo) {
		mybatis.update("userContentDAO.like_up",vo);
	}
	
	
	public void like_down(likeVO vo) {
		mybatis.update("userContentDAO.like_down",vo);
	}
	
	
	public int find_c_like(likeVO vo) {
		return mybatis.selectOne("userContentDAO.find_c_like",vo);
	}
}
