package com.jiseung.sb4.schedule;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jiseung.sb4.board.BoardVO;
import com.jiseung.sb4.board.notice.NoticeMapper;
import com.jiseung.sb4.util.Pager;

@Component
public class CustomSchedule {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	//@Scheduled(fixedRate = 1000, initialDelay = 2000) //1000 = 1초
	//@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void fixedRateTest() throws Exception{
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("------------------- Fixed Rate Test -------------------");
		
	}
	
	//@Scheduled(fixedDelay = 1000, initialDelay = 2000)
	public void fixedDelayTest() throws Exception{
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("------------------- Fixed Delay Test -------------------");
	}
	
	
	//@Scheduled(cron = " * * * * * * ")
	public void CronTest() throws Exception{
		
		System.out.println(Thread.currentThread().getName());
		Calendar ca = Calendar.getInstance();
		System.out.println("------------------- Cron Test -------------------");
		System.out.println(ca.getTime());
		
//		Pager pager = new Pager();
//		pager.setCurPage(1);
//		pager.makeRow();
//		
//		List<BoardVO> ar = noticeMapper.getList(pager);
//		for(BoardVO boardVO : ar) {
//			System.out.println(boardVO.getTitle());
//		}
	}

}
