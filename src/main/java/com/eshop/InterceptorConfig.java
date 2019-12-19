package com.eshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.eshop.interceptor.AdminInterceptor;
import com.eshop.interceptor.AuthInterceptor;
import com.eshop.interceptor.EShopInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	EShopInterceptor eshopInterceptor;
	
	@Autowired
	AuthInterceptor auth;
	
	@Autowired
	AdminInterceptor admin;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auth).addPathPatterns("/account/edit", "/account/change", "/order/**");
		registry.addInterceptor(admin).addPathPatterns("/admin/**");
		registry.addInterceptor(eshopInterceptor).addPathPatterns("/**");
	}
}
