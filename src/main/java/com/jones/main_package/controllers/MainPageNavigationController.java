package com.jones.main_package.controllers;

import com.jones.main_package.models.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MainPageNavigationController {

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("pageTitle","Jones SWGoH Team Tool - Home page");
        return "index";
    }

    @RequestMapping("/myHeroes")
    public String getMyHeroes(Model model){
        model.addAttribute("heroes", Hero.getAllHeroes());
        return "teams/myHeroes";
    }
}
