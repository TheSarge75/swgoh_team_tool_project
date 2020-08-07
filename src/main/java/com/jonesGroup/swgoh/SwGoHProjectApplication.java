package com.jonesGroup.swgoh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@RestController
public class SwGoHProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwGoHProjectApplication.class, args);
	}

	@GetMapping("/lightSide")
	public String openTheLightSidePage() {
		String htmlStr;
		try {
			File htmlFile = new File("/Users/josh_1/IdeaProjects/swgohartifact/src/main/resources/static/html/lightside.html");
			Document document = Jsoup.parse(htmlFile,"UTF-8");
			htmlStr = document.html();
		}
		catch (IOException ioex){
			htmlStr = ioex.getLocalizedMessage();
		}
		return htmlStr;
	}

	@GetMapping("/darkSide")
	public String openTheDarkSidePage() {
		return "You have chosen the Dark side.";
	}
}
