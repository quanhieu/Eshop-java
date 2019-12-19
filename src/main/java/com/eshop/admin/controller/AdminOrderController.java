package com.eshop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshop.dao.OrderDAO;
import com.eshop.entity.Order;
import com.eshop.service.HttpService;

@Controller
@RequestMapping("admin/order")
public class AdminOrderController {
	@Autowired
	HttpService http;
	
	@Autowired
	OrderDAO dao;
	
	@RequestMapping("index")
	public String index(Model model) {
		Order entity = new Order();
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("order/index");
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Order entity = dao.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("order/index");
	}
	
	@RequestMapping("create")
	public String create(Order order, RedirectAttributes attrs) {
		dao.create(order);
		attrs.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/order/index";
	}
	
	@RequestMapping("update")
	public String update(Order order, RedirectAttributes attrs) {
		dao.update(order);
		attrs.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/order/edit/" + order.getId();
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attrs) {
		dao.delete(id);
		attrs.addAttribute("message", "Xóa thành công!");
		return "redirect:/admin/order/index";
	}
}
