package com.jiseung.sb4.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberVO memberVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.getMemberLogin(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}else {
			String msg = "로그인에 실패했습니다.";
			mv.addObject("msg", msg);
			mv.addObject("path","./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@GetMapping("memberLogout")
	public String getmemberLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	
	
	@GetMapping("memberJoin")
	public ModelAndView setInsert(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setInsert(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("member/memberJoin");
			return mv;
		}
		
		int result = memberService.setInsert(memberVO, files);
		
		if(result>0) {
			mv.addObject("msg", "가입 완료");
			mv.addObject("path", "${pageContext.request.contextPath}/");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@GetMapping("memberPage")
	public ModelAndView getMemberPage(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getMemberLogin(memberVO);
		
		mv.setViewName("member/memberPage");
		
		return mv;
	}

}
