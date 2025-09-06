package com.springbootweekone.weekone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeekoneApplication implements CommandLineRunner {
	//dependency injection is a part of ioc container.ioc container manages the bean.DI duty is to inject the dependencies whereever required
//	@Autowired //it notify the spring that this object should be injected whereever it required
//	Apple apple1;
//
//	@Autowired
//	Apple apple2;

	@Autowired
	private DBService dbService;

	public static void main(String[] args) {

		SpringApplication.run(WeekoneApplication.class, args);
		//System.out.println("namaste");
	}


	@Override
	public void run(String... args) throws Exception {
//		apple1.eat();
//		System.out.println(apple1.hashCode());
//		System.out.println(apple2.hashCode());
		System.out.println(dbService.getData());
	}
}
