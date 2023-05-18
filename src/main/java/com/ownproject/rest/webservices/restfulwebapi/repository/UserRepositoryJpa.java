//package com.ownproject.rest.webservices.restfulwebapi.repository;
//
//import com.ownproject.rest.webservices.restfulwebapi.user.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@Transactional
//public class UserRepositoryJpa {
//
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    public User findByIdManager(int id) {
//        return entityManager.find(User.class, id);
//    }
//
//    public void deleteByIdManager(int id) {
//        User user = entityManager.find(User.class, id);
//        entityManager.remove(user);
//    }
//
//    public void createUserManager(User user){
//        entityManager.merge(user);
//    }
//
//    public List<User> findAllManager() {
//        return entityManager.createQuery("select t from user_ex t").getResultList();
//    }
//}
