package com.jiseung.sb4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.sb4.board.BoardVO;
import com.jiseung.sb4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	
	@ModelAttribute(name="board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> ar =  qnaService.getList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardWrite");
		
		return mv;
		
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		for(MultipartFile f : files) {
			System.out.println(f.getOriginalFilename());
		}
		
		int result = qnaService.setInsert(boardVO, files);
		String msg = "글작성이 완료됐습니다.";
		
		if(result>0) {
			mv.addObject("result", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		
		return mv;
	}

}
