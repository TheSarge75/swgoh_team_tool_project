package com.jonesGroup.swgoh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SwGoHProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(SwGoHProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SwGoHProjectApplication.class, args);
	}

	@GetMapping("/login")
	public String openTheLoginPage(
			@RequestParam(value = "username", defaultValue = "noUser") String usrnm,
			@RequestParam(value = "password", defaultValue = "noPassword") String pwd){
		log.info("Login page opening...");
		return String.format("Hello, %s! Your password is: %s",usrnm,pwd);
	}

	@GetMapping("/lurk")
	public String openTheLurkerPage() {
		log.info("Lurker page opening...");
		return "You chose to lurk, eh?";
	}
}
