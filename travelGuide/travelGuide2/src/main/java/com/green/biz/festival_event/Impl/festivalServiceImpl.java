package com.green.biz.festival_event.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.festival_event.festivalService;
import com.green.biz.festival_event.festivalVO;

@Service("festivalService")
public class festivalServiceImpl implements festivalService {
	
	@Autowired
	private festivalDAO festivalDao;
	
	@Override
	public void insert_festival(festivalVO vo) {
		festivalDao.insert_festival(vo);
	}

	@Override
	public List<festivalVO> festival_list(festivalVO vo) {

		return festivalDao.festival_list(vo);
	}

	@Override
	public festivalVO get_festival(festivalVO vo) {

		return festivalDao.get_festival(vo);
	}

	@Override
	public void update_festival(festivalVO vo) {
		
		festivalDao.update_festival(vo);
	}

	@Override
	public void delete_festival(festivalVO vo) {

		festivalDao.delete_festival(vo);
	}

}
