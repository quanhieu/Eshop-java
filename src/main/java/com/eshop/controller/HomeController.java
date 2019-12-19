package com.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.service.HttpService;

@Controller
@RequestMapping("home")
public class HomeController {
	@Autowired
	HttpService http;
	
	@RequestMapping("index")
	public String index() {
		return http.layout("home/index");
	}
	
	@RequestMapping("about")
	public String about() {
		return http.layout("home/about");
	}
	
	@RequestMapping("contact")
	public String contact() {
		return http.layout("home/contact");
	}
	
	@RequestMapping("feedback")
	public String feedback() {
		return http.layout("home/feedback");
	}
	
	@RequestMapping("faq")
	public String faq() {
		return http.layout("home/faq");
	}
	
	@ResponseBody
	@RequestMapping("lang")
	public void lang() {	}
}
