package com.green.biz.like;

public interface likeService {

	likeVO find_like(likeVO vo);

	void insert_like(likeVO vo);

	void like_up(likeVO vo);

	void like_down(likeVO vo);

	int find_c_like(likeVO vo);

}