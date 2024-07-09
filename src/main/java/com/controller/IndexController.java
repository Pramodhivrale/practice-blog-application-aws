package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.binding.PostForm;
import com.binding.UserRegForm;
import com.response.RegistraionData;
import com.service.UserServiceImpl;

@Controller
public class IndexController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/")
	public String loadRegPage(Model model) {
		model.addAttribute("user", new UserRegForm());
		return "regestration";

	}

	@PostMapping("/register")
	public String regUser(RegistraionData registraionData, Model model) {
		String registerUser = userServiceImpl.registerUser(registraionData);
		model.addAttribute("msg", registerUser);
		model.addAttribute("user", new RegistraionData());
		return "regestration";

	}

	@GetMapping("/login")
	public String loadLoginPage(Model model) 
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
			            @RequestParam("password") String password,Model model) 
	{
		
		String loginUser = userServiceImpl.loginUser(email, password);
		
		if(loginUser.contains("Succesfully loged in")) 
		{
			return "redirect:/post";
		}
		else {
	        model.addAttribute("msg", loginUser);
			return "login";
		}
				
	} 
	
	@GetMapping("/post")
	public String newForm(Model model) 
	{
		model.addAttribute("post", new PostForm());
		
		return "post";
	}
	
}
