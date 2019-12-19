package com.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.service.HttpService;
import com.eshop.service.ShoppingCartService;

@Controller
@RequestMapping("cart")
public class ShoppingCartController {
	@Autowired
	HttpService http;
	
	@Autowired
	ShoppingCartService cart;
	
	@ResponseBody
	@RequestMapping("add/{id}")
	public Map<String, Object> add(@PathVariable("id") Integer id) {
		cart.add(id);
		
		Map<String, Object> map = new HashMap<>();
		map.put("count", cart.getCount());
		map.put("amount", cart.getAmount());
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping("remove/{id}")
	public Map<String, Object> remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		
		Map<String, Object> map = new HashMap<>();
		map.put("count", cart.getCount());
		map.put("amount", cart.getAmount());
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping("update/{id}/{qty}")
	public Map<String, Object> update(
			@PathVariable("id") Integer id, @PathVariable("qty") Integer qty) {
		cart.update(id, qty);
		
		Map<String, Object> map = new HashMap<>();
		map.put("count", cart.getCount());
		map.put("amount", cart.getAmount());
		
		return map;
	}
	
	@RequestMapping("index")
	public String index() {
		return http.layout("cart/index");
	}
	
	@RequestMapping("clear")
	public String clear() {
		cart.clear();
		return http.layout("cart/index");
	}
}
