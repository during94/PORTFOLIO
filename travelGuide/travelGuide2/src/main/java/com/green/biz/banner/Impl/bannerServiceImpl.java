package com.green.biz.banner.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.banner.bannerService;
import com.green.biz.banner.bannerVO;

@Service("bannerService")
public class bannerServiceImpl implements bannerService {
	
	@Autowired
	private bannerDAO bannerDao;

	@Override
	public void banner_insert(bannerVO vo) {
		bannerDao.banner_insert(vo);
	}

	@Override
	public List<bannerVO> banner_list(bannerVO vo) {
		
		return bannerDao.banner_list(vo);
	}

	@Override
	public bannerVO get_banner(bannerVO vo) {
		
		return bannerDao.get_banner(vo);
	}

	@Override
	public void update_banner(bannerVO vo) {
		bannerDao.update_banner(vo);

	}

	@Override
	public void delete_banner(bannerVO vo) {
		bannerDao.delete_banner(vo);
		
	}

}
