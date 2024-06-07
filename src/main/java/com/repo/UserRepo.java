package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserRegistrationEntity;

public interface UserRepo extends JpaRepository<UserRegistrationEntity, Integer>
{

	public UserRegistrationEntity findByUserEmailAndUserPassword(String userEmail, String userPassword);

	
	
	
}
