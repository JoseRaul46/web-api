package com.ownproject.rest.webservices.restfulwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
public class RestfulWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebApiApplication.class, args);

//		List<Integer> listNumber = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		printAllNumberInTheList(listNumber);
//
//		System.out.println("----------------------------------------");
//
//		printFilteredNumberInTheList(listNumber);
	}

	private static void printFilteredNumberInTheList(List<Integer> listNumber) {
		Predicate<Integer> filtering = (Integer i) -> i % 2 == 0;
		listNumber.stream().filter(filtering).forEach(System.out::println);

		System.out.println("----------------------------------------");

		listNumber.stream().filter(num -> num % 2 == 1).forEach(System.out::println);
	}

	private static void printAllNumberInTheList(List<Integer> listNumber) {
		listNumber.forEach((System.out::println));
	}

}
