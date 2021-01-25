package com.green.biz.Area;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.UserContent.UserContentVO;

@Repository
public class AreaDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public UserContentVO getKind(UserContentVO vo) {
		return mybatis.selectOne("userContentDAO.find_kind", vo);
	}
	
}
