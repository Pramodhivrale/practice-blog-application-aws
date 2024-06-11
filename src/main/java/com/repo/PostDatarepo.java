package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.PostEntity;
import com.entity.UserRegistrationEntity;

@Repository
public interface PostDatarepo extends JpaRepository<PostEntity, Integer>
{

	public List<PostEntity> findByUser(UserRegistrationEntity user);


	

}
