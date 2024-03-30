package com.myrepo.mybanking;

import com.myrepo.mybanking.controllers.MainController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybankingApplication implements CommandLineRunner {

	private MainController mainController;

	public MybankingApplication() {

	}

	public static void main(String[] args) {
		SpringApplication.run(MybankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.mainController = new MainController();
	}
}
