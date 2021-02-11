package com.jonesGroup.swgoh.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

@SpringBootTest
class UserHomePageControllerTest {

    private static UserHomePageController userHomePageController;
    private static String str;

    @BeforeTestExecution
    private static void setup(){
        userHomePageController = new UserHomePageController();
        str = userHomePageController.getUserHomePage("goodusername", "goodpassword", new Model() {
            @Override
            public Model addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        });
    }

    @Test
    void itShouldReturnTheCorrectString(){
        Assertions.assertSame(str,"userhomepage");
    }
}