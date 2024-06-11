package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.binding.CommentForm;
import com.entity.CommentsEntity;
import com.entity.PostEntity;
import com.response.AddPostData;
import com.response.ShowPost;
import com.service.PostServiceImpl;

@Controller
public class PostController {
	@Autowired
	private PostServiceImpl postServiceImpl;

	

	@PostMapping("/submitpost")
	public String addPost(@ModelAttribute("post") AddPostData addPostData, Model model) {
		String msg = postServiceImpl.addPost(addPostData);
		model.addAttribute("respo", msg);
		return "post";
	}
	@GetMapping("/submitpost")
	public String addBlog(Model model) 
	{
		model.addAttribute("post", new AddPostData());
		return "post";
		
	}

	@GetMapping("/posts")
	public String showAllPosts(Model model) {
		List<PostEntity> allPost = postServiceImpl.getAllPost();
		model.addAttribute("posts", allPost);
		return "allposts";
	}

	@GetMapping("/post-details/{postId}")
	public String postsInDetails(@PathVariable Integer postId, Model model) {

		PostEntity postData = postServiceImpl.getPost(postId);
		List<CommentsEntity> comments = postServiceImpl.getComments(postId);

		ShowPost post = new ShowPost();
		post.setPostId(postData.getPostId());
		post.setTitle(postData.getTitle());
		post.setCreatedDate(postData.getCreatedOn());
		post.setMaindata(postData.getMainContent());

		model.addAttribute("post", post);
		model.addAttribute("d", post.getPostId());
		model.addAttribute("commentForm", new CommentForm());
		model.addAttribute("comments", comments);
		return "detailpost";
	}

	@PostMapping("/comment/{postId}")
	public String addComment(@PathVariable("postId") Integer id, @ModelAttribute CommentForm commentForm) {
		
		postServiceImpl.addComment(id, commentForm);
		
		
		return "redirect:/post-details/" + id;
	}



}
