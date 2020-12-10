package com.jiseung.sb4.member;

import org.apache.ibatis.annotations.Mapper;

import com.jiseung.sb4.board.file.FileVO;

@Mapper
public interface MemberMapper {
	
	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setInsertFile(MemberFileVO memberFileVO) throws Exception;
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
	
	public String getMemberIdCheck(MemberVO memberVO) throws Exception;

	
}
