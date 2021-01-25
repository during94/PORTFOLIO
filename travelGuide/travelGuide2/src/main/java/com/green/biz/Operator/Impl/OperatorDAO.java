package com.green.biz.Operator.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.Operator.OperatorVO;

@Repository
public class OperatorDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public OperatorVO getOperator(OperatorVO vo) {
		return mybatis.selectOne("OperatorDAO.getOperator", vo);
	}
}
