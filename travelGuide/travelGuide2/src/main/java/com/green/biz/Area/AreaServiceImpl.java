package com.green.biz.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.UserContent.UserContentVO;

@Service("AreaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDAO AreaDao;
	
	@Override
	public UserContentVO getKind(UserContentVO vo) {
		
		return AreaDao.getKind(vo);
	}

}
