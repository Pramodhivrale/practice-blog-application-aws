package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.binding.UpdateForm;
import com.binding.UserRegForm;
import com.entity.PostEntity;
import com.response.EditForm;
import com.service.PostServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private PostServiceImpl postServiceImpl;

	@GetMapping("/yourblogs")
	public String getYourBlogs(Model model) {
		init(model);
		return "yourblogs";
	}

	private void init(Model model) {
		Integer id = (Integer) httpSession.getAttribute("UserId");
		List<PostEntity> yourBlogs = postServiceImpl.getYourBlogs(id);
		model.addAttribute("items", yourBlogs);
	}

	@PostMapping("/delete/{id}")
	public String deleteBlog(@PathVariable("id") Integer id, Model model) {

		String deletById = postServiceImpl.deletById(id);
		model.addAttribute("msg", deletById);
		init(model);
		return "yourblogs";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		httpSession.invalidate();
		model.addAttribute("user", new UserRegForm());
		return "regestration";
	}

	@GetMapping("/edit/{id}")
	public String editBlog(@PathVariable("id") Integer id, Model model) {

		PostEntity edit = postServiceImpl.editblog(id);

		EditForm e = new EditForm();
		e.setTitle(edit.getTitle());
		e.setShortDescription(edit.getShortDescription());
		e.setMainContent(edit.getMainContent());
        e.setId(edit.getPostId());
		model.addAttribute("update", e);
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable ("id") Integer id,
			             @ModelAttribute ("update") UpdateForm updateForm,Model model) 
	{

		String updateBlog = postServiceImpl.updateBlog(id, updateForm);
		//model.addAttribute("", updateBlog);
		model.addAttribute("update", new EditForm());
		return "update";
		
	}

}
