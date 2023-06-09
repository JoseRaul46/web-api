package com.ownproject.rest.webservices.restfulwebapi.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

//    public HelloWorldController(MessageSource messageSource) {
//        this.messageSource = messageSource;
//    }

    @RequestMapping
    public String helloWorldDefault(){
        return "Hello world from spring boot";
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("hello world %s",name));
    }

    @GetMapping(path = "/hello-world-international")
    public String helloWorldInternational(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.mssg", null, "Default", locale);
    }

}
