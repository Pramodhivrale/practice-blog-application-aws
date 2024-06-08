package com.service;

import java.util.List;

import com.binding.CommentForm;
import com.entity.CommentsEntity;
import com.entity.PostEntity;
import com.response.AddPostData;

public interface PostService 
{
	public String addPost(AddPostData addPostData);
	
	public List<PostEntity> getAllPost();
	
	public PostEntity getPost(Integer id);
	
	public String addComment(Integer id,CommentForm commentForm);
	
	public List<CommentsEntity> getComments(Integer id);
		
	

}
