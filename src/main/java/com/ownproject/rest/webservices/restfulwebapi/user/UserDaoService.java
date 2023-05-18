package com.ownproject.rest.webservices.restfulwebapi.user;

import com.ownproject.rest.webservices.restfulwebapi.repository.UserSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoService {
//    @Autowired
//    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    private UserSpringDataRepository springDataRepository;

    public List<User> findAll(){
        return springDataRepository.findAll();
    }

    public List<User> findByName(String name) {
//        return springDataRepository.findByNameIgnoreCase(name);
        return springDataRepository.findByNameIsContainingIgnoreCase(name);
    }
    public void saveUser(User user){
        springDataRepository.save(user);
    }

    public User findOne(int id) {
        return springDataRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    public void deleteById(int id) {
        springDataRepository.deleteById(id);
    }

//    public List<User> findAll(){
//        return userRepositoryJpa.findAllManager();
//    }
//
//    public void saveUser(User user){
//        userRepositoryJpa.createUserManager(user);
//    }
//
//    public User findOne(int id) {
//        return userRepositoryJpa.findByIdManager(id);
//    }
//
//    public void deleteById(int id) {
//        userRepositoryJpa.deleteByIdManager(id);
//    }


}
