package com.service;

import java.util.List;

import com.entity.PostEntity;
import com.response.AddPostData;

public interface PostService 
{
	public String addPost(AddPostData addPostData);
	
	public List<PostEntity> getAllPost();
	
	public PostEntity getPost(Integer id);
		
	

}
