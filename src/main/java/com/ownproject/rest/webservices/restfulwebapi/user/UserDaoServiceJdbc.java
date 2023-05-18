//package com.ownproject.rest.webservices.restfulwebapi.user;
//
//import com.ownproject.rest.webservices.restfulwebapi.repository.UserRepositoryJdb;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class UserDaoServiceJdbc {
//
//    @Autowired
//    private UserRepositoryJdb userRepositoryJdb;
//
//    public List<User> findAll(){
//        return userRepositoryJdb.findAll();
//    }
//
//    public void saveUser(User user){
//        userRepositoryJdb.insert(user);
//    }
//
//    public User findOne(int id) {
//        return userRepositoryJdb.findeOne(id);
//    }
//
//    public void deleteById(int id) {
//        userRepositoryJdb.deleteById(id);
//    }
//}
