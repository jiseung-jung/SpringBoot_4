package com.jiseung.sb4;

import static org.junit.jupiter.api.Assertions.*;


import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlTest {

	@Autowired
	private SqlSession session;

	@Test
	void test() throws Exception {
		assertNotNull(session.getConnection());
	}

}
