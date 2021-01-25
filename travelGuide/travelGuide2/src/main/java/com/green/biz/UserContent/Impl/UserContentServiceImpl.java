package com.green.biz.UserContent.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.UserContent.UserContentService;
import com.green.biz.UserContent.UserContentVO;
import com.green.biz.util.Criteria;
import com.green.biz.util.SearchCriteria;

@Service("UserContentService")
public class UserContentServiceImpl implements UserContentService {

	@Autowired
	private UserContentDAO contentDao;
	
	@Override
	public List<UserContentVO> getUserContentList(SearchCriteria scri) {
		
		return contentDao.getUserContentList(scri);
	}

	@Override
	public void insertContent(UserContentVO vo) {

		contentDao.insertContent(vo);
	}

	@Override
	public UserContentVO detailContent(UserContentVO vo) {
				
		return contentDao.detailContent(vo);
	}

	@Override
	public void detail_update(UserContentVO vo) {
		
		contentDao.detail_update(vo);
	}

	@Override
	public void delete_content(UserContentVO vo) {

		contentDao.delete_content(vo);
	}

	@Override
	public void c_count_up(UserContentVO vo) {
		contentDao.c_count_up(vo);
		
	}

	@Override
	public int listCount(SearchCriteria scri) {

		return contentDao.listCount(scri);
	}

	@Override
	public List<UserContentVO> AreaList(UserContentVO vo, SearchCriteria scri) {

		return contentDao.AreaList(vo, scri);
	}

	@Override
	public List<UserContentVO> getSearch_list(UserContentVO vo) {

		return contentDao.getSearch_list(vo);
	}

	@Override
	public List<UserContentVO> topList(UserContentVO vo) {

		return contentDao.topList(vo);
	}


}
