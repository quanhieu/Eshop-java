package com.eshop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.ReportDAO;
import com.eshop.service.HttpService;

@Controller
@RequestMapping("admin/report")
public class AdminReportController {
	@Autowired
	HttpService http;
	
	@Autowired
	ReportDAO dao;
	
	@RequestMapping("inventory")
	public String inventory(Model model) {
		model.addAttribute("list", dao.inventoryByCategory());
		return http.adminLayout("report/inventory");
	}
	
	@RequestMapping("revenue-by-category")
	public String revenue1(Model model) {
		model.addAttribute("list", dao.revenueByCategory());
		return http.adminLayout("report/revenue-by-category");
	}
	
	@RequestMapping("revenue-by-customer")
	public String revenue2(Model model) {
		model.addAttribute("list", dao.revenueByCustomer());
		return http.adminLayout("report/revenue-by-customer");
	}
}
