package com.green.biz.festival_event;

import java.util.List;

public interface eventService {

	void insert_event(eventVO vo);
	
	public List<eventVO> event_list(eventVO vo);

	public eventVO get_event(eventVO vo);
	
	public void update_event(eventVO vo);
	
	public void delete_event(eventVO vo);
}