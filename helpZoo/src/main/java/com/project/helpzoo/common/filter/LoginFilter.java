package com.project.helpzoo.common.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

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

// 로그인 필터(로그인이 필요한 서비스를 로그인 되지 않은 상태에서 url 직접 입력으로 접근한 경우 차단)

@WebFilter(urlPatterns = "/member/*")
public class LoginFilter implements Filter{
	
	private static final Set<String> NOT_ALLOWED_PATH =
	Collections.unmodifiableSet(new HashSet<String>
	(Arrays.asList("login", "logout", "loginAction", "idDupCheck","signUpAction","findId","findIdAction","signUp", "signUp2","signUp3","authEmail",
			"joinAuth/\\w*","findPassword","emailDupCheck","findPasswordAction",
			"passAuthAction","pwdChange")));

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
		
		String path = req.getRequestURI().substring((req.getContextPath() + "/member/").length());

		// 로그인 여부 확인
		boolean isLogin = ((Member)session.getAttribute("loginMember") != null);
		
		// 요청 주소가 제외 목록에 있는 값인지 확인
		//boolean isNotAllowedPath = NOT_ALLOWED_PATH.contains(path);
		boolean isNotAllowedPath = false;
		for(String p : NOT_ALLOWED_PATH) {
			if(Pattern.matches(p, path)) {
				isNotAllowedPath = true;
				break;
			}
		}
		
		System.out.println("path : " + path);
		System.out.println("isNotAllowedPath : " + isNotAllowedPath);
		
		// 로그인이 되거나, 제외 목록 주소가 아닌 경우
		if(isLogin || isNotAllowedPath){ 
			chain.doFilter(request, response);
		}else {
			session.setAttribute("status", "error");
			session.setAttribute("msg", "로그인 후 이용해주세요.");
			res.sendRedirect(req.getContextPath() + "/member/login");
		}
	}

	@Override
	public void destroy() {
		
		
	}
	
}
