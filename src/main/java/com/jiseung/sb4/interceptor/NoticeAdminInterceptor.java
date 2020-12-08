package com.jiseung.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jiseung.sb4.board.BoardVO;
import com.jiseung.sb4.board.notice.NoticeMapper;
import com.jiseung.sb4.member.MemberRoleVO;
import com.jiseung.sb4.member.MemberVO;

@Component
public class NoticeAdminInterceptor implements HandlerInterceptor {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
			
			boolean result = false;
			
			//1. noticeWrite? noticeUpdate? noticeDelete?
			
			//1) 요청 URI
			//System.out.println("URI : "+request.getRequestURI()); // ---> notice/noticeWrite or noticeUpdate 등등...
			//System.out.println("PathInfo : "+request.getPathInfo()); //---> null이 나옴
			//System.out.println("ServletPath : "+request.getServletPath());
			
			String path = request.getRequestURI();
			String kind = path.substring(path.lastIndexOf("notice")).replace("notice", "");
			
			System.out.println("Kind : "+kind);
			
			String msg="권한이 필요합니다.";
			
		
			if(memberVO != null) {
				List<MemberRoleVO> roles = memberVO.getRoles();
				for(MemberRoleVO memberRoleVO : roles) {
					if(memberRoleVO.getRole().equals("admin")) {
						if(kind.equals("Write")) {
							result = true;
							break;
						
						}else {
							int num = Integer.parseInt(request.getParameter("num"));
							BoardVO boardVO = new BoardVO();
							boardVO.setNum(num);
							boardVO = noticeMapper.getOne(boardVO);
							
							if(boardVO.getWriter().equals(memberVO.getId())) {
								result = true;
								break;
							}else {
								msg = "작성자만 접근이 가능합니다.";
							}
						}
					}
				}
			}
		if(!result) {
			request.setAttribute("msg", msg);
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
			
		return result;
	}

}
