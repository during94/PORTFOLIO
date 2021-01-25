package com.green.biz.banner;

import java.security.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class bannerVO {
	private int b_num;
	private String b_link;
	private String b_sub_title;
	private String b_main_title;
	private String b_image;
	private MultipartFile uploadFile;
}
