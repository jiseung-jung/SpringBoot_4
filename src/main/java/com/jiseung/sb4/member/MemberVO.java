package com.jiseung.sb4.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotEmpty
	private String id;
	@NotEmpty
	@Length(min=6, max=12)
	private String pw;
	
	private String pw2;
	@NotEmpty
	@Length(min=2)
	private String name;
	@Range(min=1, max=200)
	private long age;
	@Email
	private String email;
	
	private List<MemberRoleVO> roles;
	private MemberFileVO memberFileVO;

}
