package com.service;

import com.response.RegistraionData;

public interface UserService 
{
	public String registerUser(RegistraionData registraionData);
	
	public String loginUser(String email,String password);

}
