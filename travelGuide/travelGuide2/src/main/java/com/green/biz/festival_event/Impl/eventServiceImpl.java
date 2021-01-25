package com.green.biz.festival_event.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.festival_event.eventService;
import com.green.biz.festival_event.eventVO;

@Service("eventService")
public class eventServiceImpl implements eventService {

	@Autowired
	private eventDAO eventDao;
	
	@Override
	public void insert_event(eventVO vo) {

		eventDao.insert_event(vo);
	}

	@Override
	public List<eventVO> event_list(eventVO vo) {
		
		return eventDao.event_list(vo);
	}

	@Override
	public eventVO get_event(eventVO vo) {

		return eventDao.get_event(vo);
	}

	@Override
	public void update_event(eventVO vo) {
		eventDao.update_event(vo);
	}

	@Override
	public void delete_event(eventVO vo) {
		eventDao.delete_event(vo);
	}

}
