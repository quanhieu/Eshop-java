package com.eshop.service;

import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	public String layout(String view) {
		request.setAttribute("view", view);
		return "layout";
	}
	
	public String adminLayout(String view) {
		request.setAttribute("view", view);
		return "admin/layout";
	}
	
	public Cookie getCookie(String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	public String getCookieValue(String name, String defaultValue) {
		Cookie cookie = getCookie(name);
		if(cookie == null) {
			return defaultValue;
		}
		String decodedValue = new String(Base64.getDecoder().decode(cookie.getValue()));
		return decodedValue;
	}
	
	public void addCookie(String name, String value, int days) {
		String encodeValue = Base64.getEncoder().encodeToString(value.getBytes());
		Cookie cookie = new Cookie(name, encodeValue);
		cookie.setMaxAge(days*24*60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	public void deleteCookie(String name) {
		addCookie(name, "", 0) ;
	}
}
