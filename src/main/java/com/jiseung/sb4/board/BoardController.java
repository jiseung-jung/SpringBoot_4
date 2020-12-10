package com.jiseung.sb4.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jiseung.sb4.board.notice.NoticeService;
import com.jiseung.sb4.util.Pager;

//@RestController --> 모든 메서드 위에 ResponsBody가 들어간다면 이걸로 추가. ResponseBody가 내장되어있음
@Controller
@RequestMapping("/board/**")
public class BoardController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@GetMapping("boardSelect")
	@ResponseBody // 자동 매핑 json을 리턴
	public BoardVO boardSelect(BoardVO boardVO) throws Exception{
		System.out.println("Board Select Controller");
		boardVO = noticeService.getOne(boardVO);
		System.out.println(boardVO.getTitle());
		// {"키":"밸류", "키":"밸류"}
//		String result = "{";
//		result = result+"\"num\":"+boardVO.getNum()+",";
//		result = result+"\"title\":\""+boardVO.getTitle()+"\"}";
		
//		System.out.println(result);
		
		return boardVO;
	}
	
	@GetMapping("boardList")
	@ResponseBody
	public List<BoardVO> boardList(Pager pager) throws Exception{
		System.out.println("Board List Controller");
		List<BoardVO> ar = noticeService.getList(pager);
		return ar;
	}

}
