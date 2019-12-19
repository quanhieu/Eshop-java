package com.eshop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshop.dao.CategoryDAO;
import com.eshop.entity.Category;
import com.eshop.service.HttpService;

@Controller
@RequestMapping("admin/category")
public class AdminCategoryController {
	@Autowired
	HttpService http;
	
	@Autowired
	CategoryDAO dao;
	
	@RequestMapping("index")
	public String index(Model model) {
		Category entity = new Category();
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("category/index");
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Category entity = dao.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("category/index");
	}
	
	@RequestMapping("create")
	public String create(Category category, RedirectAttributes attrs) {
		dao.create(category);
		attrs.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/category/index";
	}
	
	@RequestMapping("update")
	public String update(Category category, RedirectAttributes attrs) {
		dao.update(category);
		attrs.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/category/edit/" + category.getId();
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attrs) {
		dao.delete(id);
		attrs.addAttribute("message", "Xóa thành công!");
		return "redirect:/admin/category/index";
	}
}
