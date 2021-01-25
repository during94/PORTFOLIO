package com.green.biz.festival_event;

import java.security.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class eventVO {
	private int e_num;
	private String e_link;
	private String e_sub_title;
	private String e_main_title;
	private int e_kind;
	private Timestamp e_regdate;
	private String e_image;
	private MultipartFile uploadFile;
}
