package com.green.biz.UserContent;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserContentVO {
	private int num;
	private String c_kind;
	private int c_up;
	private String c_title;
	private String name;
	private String id;
	private String c_content;
	private int c_count;
	private Timestamp c_regdate;
	private String c_file;
	private MultipartFile uploadFile;
}
