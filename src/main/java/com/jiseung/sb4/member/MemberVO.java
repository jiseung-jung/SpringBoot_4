package com.jiseung.sb4.member;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private long age;
	private String email;
	
	private List<MemberRoleVO> roles;
	private MemberFileVO memberFileVO;

}
