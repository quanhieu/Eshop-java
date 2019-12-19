package com.eshop.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshop.dao.ProductDAO;
import com.eshop.entity.Product;
import com.eshop.service.HttpService;

@Controller
@RequestMapping("admin/product")
public class AdminProductController {
	@Autowired
	HttpService http;
	
	@Autowired
	ProductDAO dao;
	
	@Autowired
	ServletContext app;
	
	@RequestMapping("index")
	public String index(Model model) {
		Product entity = new Product();
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("product/index");
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product entity = dao.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("product/index");
	}
	
	@RequestMapping("create")
	public String create(Product product, RedirectAttributes attrs, 
			@RequestParam("upimage") MultipartFile upimage) throws IllegalStateException, IOException {
		if(!upimage.isEmpty()) {
			product.setImage(upimage.getOriginalFilename());
			String path = app.getRealPath("/images/products/"+product.getImage());
			upimage.transferTo(new File(path));
		}
		else {
			product.setImage("item.png");
		}
		dao.create(product);
		attrs.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/product/index";
	}
	
	@RequestMapping("update")
	public String update(Product product, RedirectAttributes attrs, 
			@RequestParam("upimage") MultipartFile upimage) throws IllegalStateException, IOException {
		if(!upimage.isEmpty()) {
			String path = app.getRealPath("/images/products/"+product.getImage());
			new File(path).delete();
			
			product.setImage(upimage.getOriginalFilename());
			path = app.getRealPath("/images/products/"+product.getImage());
			upimage.transferTo(new File(path));
		}
		dao.update(product);
		attrs.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/product/edit/" + product.getId();
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attrs) {
		dao.delete(id);
		attrs.addAttribute("message", "Xóa thành công!");
		return "redirect:/admin/product/index";
	}
	
	//----------------------//
	@RequestMapping("search")
	public String search(Model model, 
			@RequestParam(value="min", defaultValue="0") Double min , 
			@RequestParam(value="max", defaultValue="9999999999") Double max, 
			@RequestParam(value="orderby", defaultValue="false") boolean orderby,
			@RequestParam(value="prop", defaultValue="id") String prop) {
		List<Product> list = dao.findByPrice(min, max, orderby, prop);
		model.addAttribute("list", list);
		return "admin/product/_result";
	}
}
