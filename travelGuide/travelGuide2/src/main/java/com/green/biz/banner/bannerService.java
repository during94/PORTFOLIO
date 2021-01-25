package com.green.biz.banner;

import java.util.List;

public interface bannerService {

	void banner_insert(bannerVO vo);

	List<bannerVO> banner_list(bannerVO vo);

	bannerVO get_banner(bannerVO vo);

	void update_banner(bannerVO vo);

	void delete_banner(bannerVO vo);

}