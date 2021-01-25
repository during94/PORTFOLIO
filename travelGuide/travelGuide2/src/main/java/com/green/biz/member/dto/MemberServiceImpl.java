package com.green.biz.member.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public MemberVO getUser(MemberVO vo) {

		return memberDao.getUser(vo);
	}

	@Override
	public void insertUser(MemberVO vo) {
		
		memberDao.insertUser(vo);
		
	}

	@Override
	public MemberVO find_id(String id) {

		return memberDao.find_id(id);
	}

	@Override
	public void updateInfo(MemberVO vo) {
		memberDao.updateInfo(vo);
		
	}

	@Override
	public MemberVO find_name_email(MemberVO vo) {

		return memberDao.find_name_email(vo);
	}

	@Override
	public MemberVO find_pwd(MemberVO vo) {

		return memberDao.find_pwd(vo);
	}

	@Override
	public void update_pwd(MemberVO vo) {

		memberDao.update_pwd(vo);
	}

}
