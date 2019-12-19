package com.eshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.eshop.entity.Customer;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cpath = request.getContextPath();
		String actionUrl = request.getRequestURI().replaceAll(cpath, "");
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			session.setAttribute("requrl", actionUrl);
			response.sendRedirect(cpath+"/account/login");
			return false;
		}
		Customer user = (Customer) session.getAttribute("user");
		if(!user.getAdmin()) {
			response.sendRedirect(cpath+"/account/denied");
			return false;
		}
		return true;
	}
}
