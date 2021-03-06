package com.jiseung.sb4.board.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.sb4.board.BoardVO;
import com.jiseung.sb4.board.file.FileVO;
import com.jiseung.sb4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	@Value("${board.notice.filePath}")
	private String filePath;
	
	
	//model.addAttribute("board", "notice") --> 이게 자동 실행
	//Controller내의 모든 메서드에 적용
	@ModelAttribute(name="board")
	public String getBoard() {
		return "notice";
	}
	
	
	
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = noticeService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(@Valid BoardVO boardVO, BindingResult bindingResult, MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		for(MultipartFile f : files) {
			System.out.println(f.getOriginalFilename());
		}
		
		System.out.println("Notice Write ---------------------");
		if(bindingResult.hasErrors()) {
			System.out.println("검증 실패 ---------------------");
			mv.setViewName("board/boardWrite");
			return mv;
		}
		
		int result = noticeService.setInsert(boardVO, files);
		String msg = "글작성에 실패했습니다.";
		
		if(result>0) {
			msg = "글작성에 성공했습니다.";
			mv.addObject("result", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getOne(boardVO);
		
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("noticeFileDown")
	public ModelAndView getnoticeFileDown(FileVO fileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		fileVO = noticeService.getFile(fileVO);
		System.out.println(fileVO.getFileName());
		
		mv.addObject("fileVO", fileVO);
		mv.addObject("filePath", filePath);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardVO = noticeService.getOne(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardUpdate");
		
		return mv;
		
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, String msg) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(boardVO);
		msg = "수정 실패";
		
		if(result>0) {
			msg = "수정 성공";
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeSelect?num="+boardVO.getNum());
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	
	@PostMapping("noticeDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setDelete(boardVO);
		String msg = "삭제 실패";
		
		if(result>0) {
			msg = "삭제 완료";
			mv.addObject("msg", msg);
		}
		
		mv.addObject("path","./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	

}
