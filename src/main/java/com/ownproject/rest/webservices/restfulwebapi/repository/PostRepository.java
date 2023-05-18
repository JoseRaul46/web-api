package com.ownproject.rest.webservices.restfulwebapi.repository;

import com.ownproject.rest.webservices.restfulwebapi.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Integer> {
}
