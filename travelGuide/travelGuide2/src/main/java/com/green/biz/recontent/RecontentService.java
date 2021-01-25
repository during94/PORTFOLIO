package com.green.biz.recontent;

import java.util.List;

public interface RecontentService {

	//RecontentVO find_all_recontent(RecontentVO vo);
	List<RecontentVO> find_all_recontent(RecontentVO vo);
	
	public RecontentVO find_re_number(RecontentVO vo);

	void insert_recontent(RecontentVO vo);

	void update_recontent(RecontentVO vo);

	void delete_recontent(RecontentVO vo);

}