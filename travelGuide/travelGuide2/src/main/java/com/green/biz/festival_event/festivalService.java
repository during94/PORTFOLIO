package com.green.biz.festival_event;

import java.util.List;

import com.green.biz.festival_event.Impl.festivalDAO;

public interface festivalService {

	void insert_festival(festivalVO vo);

	List<festivalVO> festival_list(festivalVO vo);

	festivalVO get_festival(festivalVO vo);

	void update_festival(festivalVO vo);

	void delete_festival(festivalVO vo);

}