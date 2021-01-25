package com.green.biz.recontent.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.recontent.RecontentService;
import com.green.biz.recontent.RecontentVO;

@Service("RecontentService")
public class RecontentServiceImpl implements RecontentService {
	
	@Autowired
	private RecontentDAO recontentDao;

	@Override
	public List<RecontentVO> find_all_recontent(RecontentVO vo) {

		return recontentDao.find_all_recontent(vo);
	}
	
	@Override
	public RecontentVO find_re_number(RecontentVO vo) {
		
		return recontentDao.find_re_number(vo);
	}

	@Override
	public void insert_recontent(RecontentVO vo) {

		recontentDao.insert_recontent(vo);
	}

	@Override
	public void update_recontent(RecontentVO vo) {

		recontentDao.update_recontent(vo);
	}

	@Override
	public void delete_recontent(RecontentVO vo) {

		recontentDao.delete_recontent(vo);
	}
}
