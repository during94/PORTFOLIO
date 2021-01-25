package com.green.biz.banner.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.banner.bannerVO;

@Repository
public class bannerDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void banner_insert(bannerVO vo) {
		mybatis.insert("bannerDAO.insert_banner",vo);
	}
	
	public List<bannerVO> banner_list(bannerVO vo) {
		
		return mybatis.selectList("bannerDAO.banner_list",vo);
		
	}
	
	public bannerVO get_banner(bannerVO vo) {
		return mybatis.selectOne("bannerDAO.get_banner",vo);
	}
	
	public void update_banner(bannerVO vo) {
		mybatis.update("bannerDAO.update_banner", vo);
	}
	
	public void delete_banner(bannerVO vo) {
		mybatis.update("bannerDAO.delete_banner", vo);
	}
}
