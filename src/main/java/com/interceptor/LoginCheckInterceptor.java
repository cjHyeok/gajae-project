package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle==========");
		System.out.println("로그인 인터");
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {// 로그인시

			System.out.println("request==" + request);

			String uri = request.getRequestURI();
			StringBuffer url = request.getRequestURL();
			String contextPath = request.getContextPath();
			String remoteAddr = request.getRemoteAddr();
			//System.out.println("uri==========" + uri);
			//System.out.println("url==========" + url);
			//System.out.println("contextPath==========" + contextPath);
			//System.out.println("remoteAddr==========" + remoteAddr);

			session.setAttribute("clickLink", uri);

			response.sendRedirect("../loginForm");// servlet-context.xml
			
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
