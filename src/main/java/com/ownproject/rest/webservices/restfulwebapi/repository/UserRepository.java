package com.ownproject.rest.webservices.restfulwebapi.repository;

import com.ownproject.rest.webservices.restfulwebapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRepository  {

    @Autowired
    private UserSpringDataRepository springDataRepository;

    public User findById(int id) {

        return springDataRepository.findById((Integer)id).orElse(null);
    }

    public void deleteByIdManager(int id) {
        springDataRepository.delete(new User(id));
    }

    public void createUserManager(User user){
        springDataRepository.save(user);
    }

    public List<User> findAllManager() {
        return springDataRepository.findAll();
    }
}
