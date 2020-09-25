package com.project.helpzoo.common.filter;

import java.io.IOException;
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

@WebFilter(urlPatterns = "/mypage/*")
public class MypageFilter implements Filter{
	// 로그인 필터(로그인이 필요한 서비스를 로그인 되지 않은 상태에서 url 직접 입력으로 접근한 경우 차단)

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

			// 로그인 여부 확인
			boolean isLogin = ((Member)session.getAttribute("loginMember") != null);
			
			// 로그인이 되거나, 제외 목록 주소가 아닌 경우
			if(isLogin){ 
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

