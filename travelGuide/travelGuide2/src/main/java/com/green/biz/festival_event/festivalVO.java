package com.green.biz.festival_event;

import java.security.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class festivalVO {
	private int f_num;
	private String f_link;
	private String f_sub_title;
	private String f_main_title;
	private int f_kind;
	private Timestamp f_regdate;
	private String f_image;
	private MultipartFile uploadFile;
	
}
