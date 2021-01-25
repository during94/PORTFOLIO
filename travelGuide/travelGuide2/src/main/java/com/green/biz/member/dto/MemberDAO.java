package com.green.biz.member.dto;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.member.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberVO find_id(String id) {
		return mybatis.selectOne("memberDAO.find_id", id);
	}
	
	public MemberVO getUser(MemberVO vo) {
		
		return mybatis.selectOne("memberDAO.getUser", vo);
	}
	
	public void insertUser(MemberVO vo) {
		
		mybatis.insert("memberDAO.inserUser",vo);
	}
	
	public void updateInfo(MemberVO vo) {
		
		mybatis.update("memberDAO.updateInfo", vo);
	}
	
	public MemberVO find_name_email(MemberVO vo) {
		return mybatis.selectOne("memberDAO.find_name_email",vo);
	}
	
	public MemberVO find_pwd(MemberVO vo) {
		
		return mybatis.selectOne("memberDAO.find_pwd", vo);
	}
	
	public void update_pwd(MemberVO vo) {
		mybatis.update("memberDAO.update_pwd", vo);
	}
	
}
