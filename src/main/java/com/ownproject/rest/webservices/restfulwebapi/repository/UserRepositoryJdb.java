//package com.ownproject.rest.webservices.restfulwebapi.repository;
//
//import com.ownproject.rest.webservices.restfulwebapi.user.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class UserRepositoryJdb {
//
//    @Autowired
//    private JdbcTemplate springJdbctemplate;
//
//    private static String INSERT_QUERY = """
//                insert into user_ex(name_col, birthdate_col) values (?, ?);
//            """;
//    private static String DELETE_QUERY = """
//                delete from user_ex where id = ?;
//            """;
//
//    private static String FIND_ONE_QUERY = """
//                select * from user_ex where id = ?;
//            """;
//
//    private static String FIND_ALL_QUERY = """
//                select * from user_ex ;
//            """;
//
//    public void insert(User user){
//        springJdbctemplate.update(INSERT_QUERY, user.getName(), user.getBirthDate());
//    }
//
//    public void deleteById(int id) {
//        springJdbctemplate.update(DELETE_QUERY, id);
//    }
//
//    public List<User> findAll() {
//        return springJdbctemplate.query(FIND_ALL_QUERY, new BeanPropertyRowMapper<>(User.class));
//    }
//
//    public User findeOne(int id) {
//        return springJdbctemplate.queryForObject(FIND_ONE_QUERY, new BeanPropertyRowMapper<>(User.class), id);
//    }
//}
