package com.ownproject.rest.webservices.restfulwebapi.repository;

import com.ownproject.rest.webservices.restfulwebapi.user.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSpringDataRepository extends JpaRepository<User, Integer> {

    List<User> findByNameIgnoreCase(String name);

    List<User> findByNameIsContainingIgnoreCase(String name);
}
