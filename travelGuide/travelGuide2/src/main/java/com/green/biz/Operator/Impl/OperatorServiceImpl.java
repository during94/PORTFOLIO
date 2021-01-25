package com.green.biz.Operator.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.Operator.OperatorService;
import com.green.biz.Operator.OperatorVO;

@Service("OperatorService")
public class OperatorServiceImpl implements OperatorService {
	
	@Autowired
	private OperatorDAO operatorDao;

	@Override
	public OperatorVO getOperator(OperatorVO vo) {

		return operatorDao.getOperator(vo);
	}

}
