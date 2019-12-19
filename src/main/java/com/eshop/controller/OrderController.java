package com.eshop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.OrderDAO;
import com.eshop.entity.Customer;
import com.eshop.entity.Order;
import com.eshop.entity.Product;
import com.eshop.service.HttpService;
import com.eshop.service.ShoppingCartService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	HttpService http;
	@Autowired
	HttpSession session;
	@Autowired
	ShoppingCartService cart;
	
	@Autowired
	OrderDAO dao;
	
	@GetMapping("checkout")
	public String checkout(Model model) {
		Customer customer = (Customer) session.getAttribute("user");
		
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setCustomer(customer);
		order.setAmount(cart.getAmount());
		
		model.addAttribute("order", order);
		
		return http.layout("order/checkout");
	}
	
	@PostMapping("purchase")
	public String purchase(Model model, @ModelAttribute("order") Order order) {
		dao.create(order, cart);
		cart.clear();
		return "redirect:/order/detail/"+order.getId();
	}
	
	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Order order = dao.findById(id);
		model.addAttribute("order", order);
		return http.layout("order/detail");
	}
	
	@GetMapping("list")
	public String list(Model model) {
		Customer customer = (Customer) session.getAttribute("user");
		List<Order> orders = dao.findByCustomer(customer);
		model.addAttribute("orders", orders);
		return http.layout("order/list");
	}
	
	@GetMapping("items")
	public String items(Model model) {
		Customer customer = (Customer) session.getAttribute("user");
		List<Product> list = dao.findItemsByCustomer(customer);
		model.addAttribute("list", list);
		return http.layout("product/list");
	}
}
