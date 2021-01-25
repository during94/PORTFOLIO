package com.green.biz.recontent.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.recontent.RecontentVO;

@Repository
public class RecontentDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<RecontentVO> find_all_recontent(RecontentVO vo) {
		return mybatis.selectList("userContentDAO.find_all_recontent", vo);
	}
	
	public RecontentVO find_re_number(RecontentVO vo) {
		return mybatis.selectOne("userContentDAO.find_re_number", vo);
	}
	
	public void insert_recontent(RecontentVO vo) {
		mybatis.insert("userContentDAO.insert_recontent", vo);
	}
	
	public void update_recontent(RecontentVO vo) {
		mybatis.update("userContentDAO.update_recontent", vo);
	}
	
	public void delete_recontent(RecontentVO vo) {
		mybatis.delete("userContentDAO.delete_recontent", vo);
	}
}
