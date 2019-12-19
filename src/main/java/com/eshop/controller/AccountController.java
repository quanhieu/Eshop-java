package com.eshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.dao.CustomerDAO;
import com.eshop.entity.Customer;
import com.eshop.service.HttpService;
import com.eshop.service.MailerService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	HttpService http;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext app;
	
	@Autowired
	CustomerDAO dao;
	
	@Autowired
	MailerService mailer;
	
	@GetMapping("denied")
	public String denied() {
		return http.layout("account/denied");
	}
	
	@GetMapping("edit")
	public String edit(Model model) {
		model.addAttribute("customer", session.getAttribute("user"));
		return http.layout("account/edit");
	}
	@PostMapping("edit")
	public String edit(Model model, @ModelAttribute("customer") Customer customer, @RequestParam("upphoto") MultipartFile file) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			String path = app.getRealPath("/images/customers/" + filename);
			file.transferTo(new File(path));
			customer.setPhoto(filename);
		}
		
		dao.update(customer);
		session.setAttribute("user", customer);
		model.addAttribute("message", "Cập nhật thành công!");
		return http.layout("account/edit");
	}
	
	@GetMapping("change")
	public String change() {
		return http.layout("account/change");
	}
	@PostMapping("change")
	public String change(Model model,
			@RequestParam("id") String id,
			@RequestParam("password") String pw,
			@RequestParam("password1") String pw1,
			@RequestParam("password2") String pw2) {
		Customer customer = dao.findById(id);
		if(customer == null) {
			model.addAttribute("message", "Sai tên đăng nhập!");
		}
		else if(!customer.getPassword().equals(pw)) {
			model.addAttribute("message", "Sai mật khẩu!");
		}
		else if(!pw1.equals(pw2)){
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
		}
		else {
			customer.setPassword(pw1);
			dao.update(customer);
			model.addAttribute("message", "Đã đổi mật khẩu thành công!");
		}
		return http.layout("account/change");
	}
	
	@GetMapping("forgot")
	public String forgot() {
		return http.layout("account/forgot");
	}
	@PostMapping("forgot")
	public String forgot(Model model, @RequestParam("id") String id, @RequestParam("email") String email) throws Exception {
		Customer customer = dao.findById(id);
		if(customer == null) {
			model.addAttribute("message", "Sai tên đăng nhập!");
		}
		else if(!customer.getEmail().equals(email)) {
			model.addAttribute("message", "Sai email đăng ký!");
		}
		else {
			mailer.send(email, "Forgot password", customer.getPassword());
			model.addAttribute("message", "Mật khẩu đã được gửi qua email!");
		}
		return http.layout("account/forgot");
	}
	
	
	@GetMapping("activate/{id}")
	public String activate(@PathVariable("id") String id) {
		String decodedId = new String(Base64.getDecoder().decode(id));
		Customer customer = dao.findById(decodedId);
		customer.setActivated(true);
		dao.update(customer);
		return "redirect:/account/login";
	}
	
	@GetMapping("register")
	public String registerGet(Model model) {
		model.addAttribute("customer", new Customer());
		return http.layout("account/register");
	}
	@PostMapping("register")
	public String registerPost(Model model, 
			@ModelAttribute("customer") Customer user,
			@RequestParam("password2") String pass2,
			@RequestParam("upphoto") MultipartFile file) {
		Customer cust = dao.findById(user.getId());
		if(!pass2.equals(user.getPassword())) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
		}
		else if(cust == null) {
			try {
				String filename = file.getOriginalFilename();
				String path = app.getRealPath("/images/customers/" + filename);
				file.transferTo(new File(path));
				user.setPhoto(filename);
				
				user.setActivated(false);
				dao.create(user);
				model.addAttribute("message", "Đăng ký thành công!");
			
				String encodedId = Base64.getEncoder().encodeToString(user.getId().getBytes());
				String url = request.getRequestURL().toString().replace("register", "activate/"+encodedId);
				String to = user.getEmail();
				String subject = "Welcome to eShop";
				String body = "<a href='?'>Kích hoạt</a>".replace("?", url);
				mailer.send(to, subject, body);
				model.addAttribute("message", "Vui lòng kích hoạt tài khoản thông qua email!");
			}
			catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Email đăng ký không hợp lệ!");
			}
		}
		else {
			model.addAttribute("message", "Mã đăng nhập này đã được sử dụng!");
		}
		return http.layout("account/register");
	}
	
	@GetMapping("logoff")
	public String logoff() {
		session.removeAttribute("user");
		return "redirect:/home/index";
	}
	
	@GetMapping("login")
	public String loginGet(Model model) {
		model.addAttribute("userid", http.getCookieValue("user", ""));
		model.addAttribute("pass", http.getCookieValue("pass", ""));
		return http.layout("account/login");
	}
	@PostMapping("login")
	public String loginPost(Model model, 
			@RequestParam("id") String id, 
			@RequestParam("password") String pass, 
			@RequestParam(value="remember", defaultValue="false") Boolean rem) {
		Customer user = dao.findById(id);
		if(user == null) {
			model.addAttribute("message", "Sai tên đăng nhập!");
		}
		else if(!user.getPassword().equals(pass)) {
			model.addAttribute("message", "Sai mật khẩu!");
		}
		else if(!user.getActivated()) {
			model.addAttribute("message", "Chưa kịch hoạt tài khoản!");
		}
		else {
			model.addAttribute("message", "Đăng nhập thành công!");
			session.setAttribute("user", user);
			if(rem == true) {
				http.addCookie("user", id, 30);
				http.addCookie("pass", pass, 30);
			}
			else {
				http.deleteCookie("user");
				http.deleteCookie("pass");
			}
			String requrl = (String) session.getAttribute("requrl");
			if(requrl != null) {
				return "redirect:"+requrl;
			}
		}
		return http.layout("account/login");
	}
}
