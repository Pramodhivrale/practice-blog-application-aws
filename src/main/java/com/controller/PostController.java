package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.binding.CommentForm;
import com.entity.PostEntity;
import com.response.AddPostData;
import com.response.ShowPost;
import com.service.PostServiceImpl;

import jakarta.websocket.server.PathParam;

@Controller
public class PostController {
	@Autowired
	private PostServiceImpl postServiceImpl;

	@PostMapping("/submitpost")
	public String addPost(@ModelAttribute("post") AddPostData addPostData, Model model) {
		String post = postServiceImpl.addPost(addPostData);
		model.addAttribute("respo", post);
		return "post";
	}

	@GetMapping("/posts")
	public String showAllPosts(Model model) 
	{
		List<PostEntity> allPost = postServiceImpl.getAllPost();
        model.addAttribute("posts", allPost);
		return "allposts";
	}
	
	 @GetMapping("/post-details/{postId}")
	public String postsInDetails(@PathVariable Integer postId,Model model) 
	{
		
		
		PostEntity postData = postServiceImpl.getPost(postId);
		
		System.out.println("Id :"+postData.getPostId());
		
		ShowPost post=new ShowPost();
		post.setTitle(postData.getTitle());
		post.setCreatedDate(postData.getCreatedOn());
		post.setMaindata(postData.getMainContent());
		
		
		model.addAttribute("post", post);
		model.addAttribute("commentForm", new CommentForm());
		return "detailpost";	
	}

}
