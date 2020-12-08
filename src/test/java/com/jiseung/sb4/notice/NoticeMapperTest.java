package com.jiseung.sb4.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jiseung.sb4.board.BoardVO;
import com.jiseung.sb4.board.notice.NoticeMapper;
import com.jiseung.sb4.board.notice.NoticeVO;
import com.jiseung.sb4.util.Pager;

@SpringBootTest
class NoticeMapperTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	
	@Test
	void getListTest() throws Exception{
		long curPage = 1;
		Pager pager = new Pager();
		pager.setCurPage(curPage);
		pager.makeRow();
		pager.setKind("writer");
		pager.setSearch("r9");
		List<BoardVO> ar =  noticeMapper.getList(pager);
		
		assertEquals(10, ar.size());
	}
	
	
	
	//@Test
	void setInsertTest() throws Exception {
		
		for(int i=0; i<100; i++) {
			NoticeVO noticeVO = new NoticeVO();
		
			noticeVO.setTitle("Test Title"+i);
			noticeVO.setWriter("Test Writer"+i);
			noticeVO.setContents("Test Contents"+i);
		
			int result = noticeMapper.setInsert(noticeVO);
		
			if(i%10 == 0) {
				Thread.sleep(1000);
			}
		}
		
		System.out.println("finish");
		
	}
	
	//@Test
	void setUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("Update Title2");
		noticeVO.setWriter("Update Writer2");
		noticeVO.setContents("Update Contents2");
		
		noticeVO.setNum(3);
		
		int result = noticeMapper.setUpdate(noticeVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void setDeleteTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setNum(6);
		
		int result = noticeMapper.setDelete(noticeVO);
		
		assertEquals(1, result);
	}
	
	
	//@Test
	void getOneTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setNum(3);
		
		BoardVO boardVO = noticeMapper.getOne(noticeVO);
		
		assertNotNull(boardVO);
	}
	
	

}
