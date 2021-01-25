package com.green.biz.UserContent;

import java.util.List;

import com.green.biz.util.Criteria;
import com.green.biz.util.SearchCriteria;

public interface UserContentService {
	
	public List<UserContentVO> AreaList(UserContentVO vo, SearchCriteria scri);
	
	public List<UserContentVO> getUserContentList(SearchCriteria scri);
	
	public List<UserContentVO> topList(UserContentVO vo);
	
	public void insertContent(UserContentVO vo);
	
	public UserContentVO detailContent(UserContentVO vo);
	
	public void detail_update(UserContentVO vo);
	
	public void delete_content(UserContentVO vo);
	
	public void c_count_up(UserContentVO vo);
	
	public int listCount(SearchCriteria scri);
	
	public List<UserContentVO> getSearch_list(UserContentVO vo);
}