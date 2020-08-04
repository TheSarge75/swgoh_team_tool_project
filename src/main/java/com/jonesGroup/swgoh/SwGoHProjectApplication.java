package com.jonesGroup.swgoh;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SwGoHProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwGoHProjectApplication.class, args);
	}

	@GetMapping("/lightSide")
	public String openTheLightSidePage(){
		return "You have chosen the Light side.";
	}

	@GetMapping("/darkSide")
	public String openTheDarkSidePage() {
		return "You have chosen the Dark side.";
	}
}
