package com.eshop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.service.HttpService;

@Controller
@RequestMapping("admin/home")
public class AdminHomeController {
	@Autowired
	HttpService http;
	
	@RequestMapping("index")
	public String index() {
		return http.adminLayout("home/index");
	}
}
