package com.github.Balashov.Lane;

import com.github.Balashov.Lane.controller.ItemController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemApplication implements CommandLineRunner {

	@Autowired
	private ItemController controller;

	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// save list Customers
		controller.itemService.generate().subscribe(x -> System.out.println(">> Generated Row: " + x));
	}

}
