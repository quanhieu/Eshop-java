package com.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.dao.CategoryDAO;
import com.eshop.dao.ProductDAO;
import com.eshop.entity.Category;
import com.eshop.entity.Product;
import com.eshop.service.HttpService;
import com.eshop.service.MailerService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	HttpService http;
	@Autowired
	CategoryDAO cdao;
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping("list-by-category/{id}")
	public String listByCategory(Model model, @PathVariable("id") Integer id) {
		Category entity = cdao.findById(id);
		model.addAttribute("list", entity.getProducts());
		return http.layout("product/list");
	}
	
	@RequestMapping("detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product entity = pdao.findById(id);
		model.addAttribute("prod", entity);
		return http.layout("product/detail");
	}
	
	@RequestMapping("latest")
	public String latest(Model model) {
		List<Product> list = pdao.findByLatest();
		model.addAttribute("list", list);
		return http.layout("product/list");
	}
	
	@RequestMapping("best")
	public String best(Model model) {
		List<Product> list = pdao.findByBest();
		model.addAttribute("list", list);
		return http.layout("product/list");
	}
	
	@RequestMapping("search")
	public String search(Model model, @RequestParam("keywords") String keywords) {
		List<Product> list = pdao.findByKeywords(keywords);
		model.addAttribute("list", list);
		return http.layout("product/list");
	}
	
	//-------------------------//

	@RequestMapping("favorite/{id}")
	public String favorite(Model model, @PathVariable("id") Integer id) {
		String ids = http.getCookieValue("favorite", id.toString());
		if(!ids.contains(id.toString())) {
			ids += "," + id.toString();
		}
		http.addCookie("favorite", ids, 30);
		
		List<Product> list = pdao.findByFavorites(ids);
		model.addAttribute("list", list);
		return "product/favorite";
	}
	
	@Autowired
	MailerService mailer;
	
	@ResponseBody
	@RequestMapping("send")
	public String send(HttpServletRequest request, @RequestParam("id") Integer id,
			@RequestParam("sender") String sender,
			@RequestParam("receiver") String receiver,
			@RequestParam("subject") String subject,
			@RequestParam("message") String message) {
		try {
			String url = request.getRequestURL().toString().replace("send", "detail/"+id);
			message += "<hr><a href='"+url+"'>Xem chi tiết</a>";
			mailer.send(sender, receiver, subject, message);
			return "Đã gửi thành công";
		} 
		catch (Exception e) {
			return "Lỗi gửi email";
		}
	}
}
