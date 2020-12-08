package com.jiseung.sb4.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(value = true)
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;

	//@Test
	void setInserttest() throws Exception{
		
		for(int i=0;i<100;i++) {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("id"+i);
		memberVO.setPw("pw"+i);
		memberVO.setName("name"+i);
		memberVO.setAge(27);
		memberVO.setEmail("test"+i+"@test.com");
		
		int result = memberMapper.setInsert(memberVO);
		
		
		}
		
	}
	
	//@Test
	void setInsertFileTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		
		memberFileVO.setId("id0");
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");

		int result = memberMapper.setInsertFile(memberFileVO);
		
		assertEquals(1, result);
	}
	
	@Test
	void getMemberLoginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("id0");
		memberVO.setPw("pw0");
		
		memberVO = memberMapper.getMemberLogin(memberVO);
		
		assertNotNull(memberVO);
		
	}

}
