package com.ownproject.rest.webservices.restfulwebapi.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.ownproject.rest.webservices.restfulwebapi.exception.UserNotFoundException;
import com.ownproject.rest.webservices.restfulwebapi.repository.PostRepository;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

@RestController
public class UserResources {

    private UserDaoService userDaoService;

    @Autowired
    private PostRepository postRepository;

    public UserResources(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveDetailUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        if(Objects.isNull(user)){
            throw new UserNotFoundException("user not found, ID:" + id);
        }

        DateTimeFormatter usDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        user.setBirthDate(LocalDate.parse(user.getBirthDate().toString(), usDateFormatter));
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(webMvcLinkBuilder.withRel("all-user"));

        return entityModel;
    }

    @GetMapping("/users/name/{name}")
    public List<EntityModel<User>> retrieveDetailUserByName(@PathVariable String name) {
        List<User> userList = userDaoService.findByName(name);

        if(userList.isEmpty()){
            throw new UserNotFoundException("user not found, Name:" + name);
        }

        List<EntityModel<User>> entityModelList = new ArrayList<>();
        for (User user : userList) {
            EntityModel<User> entityModel = EntityModel.of(user);


            WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
            entityModel.add(webMvcLinkBuilder.withRel("all-user"));
            entityModelList.add(entityModel);
        }
        return entityModelList;
    }


    @PostMapping("/users")
    public int createUser(@Valid @RequestBody User user){
        int response = 0;
        try {
            userDaoService.saveUser(user);
            response = Response.SC_OK;
        } catch (Exception exc){
            response = Response.SC_INTERNAL_SERVER_ERROR;
        }
        return response;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userDaoService.deleteById(id);
    }

    @GetMapping("/users/{id}/post")
    public List<Post> retrievePostUsers(@PathVariable int id){
        User user = userDaoService.findOne(id);

        if(Objects.isNull(user)) {
           throw new UserNotFoundException("not found user id: " + id);
        }

        return user.getPosts();
    }

    @PostMapping("/users/{id}/create-post")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        int response = 0;

        User user = userDaoService.findOne(id);
        if(Objects.isNull(user)) {
            throw new UserNotFoundException("not found user id: " + id);
        }
        post.setUser(user);
        Post postSaved = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postSaved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
