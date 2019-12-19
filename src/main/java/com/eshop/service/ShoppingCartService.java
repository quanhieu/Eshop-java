package com.eshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.eshop.dao.ProductDAO;
import com.eshop.entity.Product;

@SessionScope
@Service("cart")
public class ShoppingCartService {
	@Autowired
	ProductDAO dao;
	
	List<Product> list = new ArrayList<>();
	public void add(Integer id) {
		for(Product item : list) {
			if(item.getId().equals(id)) {
				item.setQuantity(item.getQuantity() + 1);
				return;
			}
		}
		Product item = dao.findById(id);
		item.setQuantity(1);
		list.add(item);
	}
	public void remove(Integer id) {
		for(Product item : list) {
			if(item.getId().equals(id)) {
				list.remove(item);
				return;
			}
		}
	}
	public void clear() {
		list.clear();
	}
	public void update(Integer id, int quantity) {
		for(Product item : list) {
			if(item.getId().equals(id)) {
				item.setQuantity(quantity);
				return;
			}
		}
	}
	public List<Product> getItems() {
		return list;
	}
	public int getCount() {
		int count = 0;
		for(Product item : list) {
			count+=item.getQuantity();
		}
		return count;
	}
	public double getAmount() {
		double amount = 0;
		for(Product item : list) {
			amount+=item.getQuantity()*item.getUnitPrice();
		}
		return amount;
	}
}
