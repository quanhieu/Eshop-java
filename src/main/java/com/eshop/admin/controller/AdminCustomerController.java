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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshop.dao.CustomerDAO;
import com.eshop.entity.Customer;
import com.eshop.service.HttpService;

@Controller
@RequestMapping("admin/customer")
public class AdminCustomerController {
	@Autowired
	HttpService http;
	
	@Autowired
	CustomerDAO dao;
	
	@Autowired
	ServletContext app;
	
	@RequestMapping("index")
	public String index(Model model) {
		Customer entity = new Customer();
		entity.setActivated(false);
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("customer/index");
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Customer entity = dao.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("items", dao.findAll());
		return http.adminLayout("customer/index");
	}
	
	@RequestMapping("create")
	public String create(Customer customer, RedirectAttributes attrs, 
			@RequestParam("upphoto") MultipartFile upphoto) throws IllegalStateException, IOException {
		if(!upphoto.isEmpty()) {
			customer.setPhoto(upphoto.getOriginalFilename());
			String path = app.getRealPath("/images/customers/"+customer.getPhoto());
			upphoto.transferTo(new File(path));
		}
		else {
			customer.setPhoto("user.png");
		}
		dao.create(customer);
		attrs.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/customer/index";
	}
	
	@RequestMapping("update")
	public String update(Customer customer, RedirectAttributes attrs, 
			@RequestParam("upphoto") MultipartFile upphoto) throws IllegalStateException, IOException {
		if(!upphoto.isEmpty()) {
			String path = app.getRealPath("/images/customers/"+customer.getPhoto());
			new File(path).delete();
			
			customer.setPhoto(upphoto.getOriginalFilename());
			path = app.getRealPath("/images/customers/"+customer.getPhoto());
			upphoto.transferTo(new File(path));
		}
		dao.update(customer);
		attrs.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/customer/edit/" + customer.getId();
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") String id, RedirectAttributes attrs) {
		dao.delete(id);
		attrs.addAttribute("message", "Xóa thành công!");
		return "redirect:/admin/customer/index";
	}
	
	//------------------------------------------//
	
	@RequestMapping("get-page")
	public String getPage(Model model,
			@RequestParam(value="pageNo", defaultValue="0") Integer pageNo, 
			@RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
			List<Customer> list = dao.findPage(pageNo, pageSize);
			model.addAttribute("list", list);
		return "admin/customer/_page";
	}
	
	@ResponseBody
	@RequestMapping("get-page-count")
	public long getPageCount(@RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
		long pageCount = dao.getPageCount(pageSize);
		return pageCount;
	}
}
