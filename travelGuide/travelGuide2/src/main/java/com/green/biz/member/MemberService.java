package com.green.biz.member;

public interface MemberService {
	
	public MemberVO find_id(String id);

	MemberVO getUser(MemberVO vo);
	
	public void insertUser(MemberVO vo);
	
	public void updateInfo(MemberVO vo);
	
	public MemberVO find_name_email(MemberVO vo);

	public MemberVO find_pwd(MemberVO vo);
	
	public void update_pwd(MemberVO vo);
}