package com.green.biz.member;



import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private Timestamp sysdate;
}
