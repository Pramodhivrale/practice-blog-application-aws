package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CommentsEntity;

@Repository
public interface CommentRepo extends JpaRepository<CommentsEntity, Integer>{

}
