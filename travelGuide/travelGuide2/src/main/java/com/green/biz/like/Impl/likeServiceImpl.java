package com.green.biz.like.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.like.likeService;
import com.green.biz.like.likeVO;

@Service("likeService")
public class likeServiceImpl implements likeService {
	
	@Autowired
	private likeDAO likeDao;
	
	@Override
	public likeVO find_like(likeVO vo) {
		
		return likeDao.find_like(vo);
	}

	@Override
	public void insert_like(likeVO vo) {
		likeDao.insert_like(vo);
	}

	@Override
	public void like_up(likeVO vo) {
		likeDao.like_up(vo);
	}

	@Override
	public void like_down(likeVO vo) {
		likeDao.like_down(vo);
	}

	@Override
	public int find_c_like(likeVO vo) {

		return likeDao.find_c_like(vo);
	}

}
