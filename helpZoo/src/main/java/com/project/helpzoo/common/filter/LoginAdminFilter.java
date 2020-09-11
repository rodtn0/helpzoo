package com.project.helpzoo.common.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.helpzoo.member.model.vo.Member;

// 어드민 로그인 필터(로그인이 필요한 서비스를 로그인 되지 않은 상태에서 url 직접 입력으로 접근한 경우 차단)

@WebFilter(urlPatterns = "/admin/*")
public class LoginAdminFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("로그인 필터 작동");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		boolean isLogin = false;
		// 로그인 여부 확인
		if((Member)session.getAttribute("loginMember") != null) {
			isLogin =( ( (Member)session.getAttribute("loginMember") ).getMemberGrade().equals("A") );
		}
		// 로그인이 되거나, 제외 목록 주소가 아닌 경우
		if(isLogin){ 
			chain.doFilter(request, response);
		}else {
			session.setAttribute("msg", "관리자만 이용가능합니다.");
			res.sendRedirect(req.getContextPath() + "/member/login");
		}
	}

	@Override
	public void destroy() {
		
		
	}
	
}
