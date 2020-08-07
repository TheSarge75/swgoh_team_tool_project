package com.jonesGroup.swgoh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class SwGoHProjectApplicationTests {

	private static File lightSideFile;
	private static Document lightSideDocument;

	@BeforeAll
	private static void setup(){
		lightSideFile = new File("/Users/josh_1/IdeaProjects/swgohartifact/src/main/resources/static/html/lightside.html");
		try {
			lightSideDocument = Jsoup.parse(lightSideFile, "UTF-8");
		} catch (IOException e) {
			lightSideDocument = null;
		}
	}

	@Test
	void itShouldExist(){
		Assertions.assertTrue(lightSideFile.exists());
	}

	@Test
	void itShouldNotBeNull(){
		Assertions.assertNotNull(lightSideDocument);
	}



}
