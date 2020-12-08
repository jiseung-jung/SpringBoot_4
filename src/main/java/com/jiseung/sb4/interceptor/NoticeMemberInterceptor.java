package com.jiseung.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jiseung.sb4.member.MemberRoleVO;
import com.jiseung.sb4.member.MemberVO;

@Component
public class NoticeMemberInterceptor implements HandlerInterceptor{
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		boolean result = false;
		
		if(memberVO != null) {
			List<MemberRoleVO> roles = memberVO.getRoles();
			for(MemberRoleVO memberRoleVO : roles) {
				if(memberRoleVO.getRole().equals("member")) {
					result = true;
					break;
				}
			}
		}
	if(!result) {
		request.setAttribute("msg", "권한이 필요합니다.");
		request.setAttribute("path", "../");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
	}
		
	return result;
}
	

}
