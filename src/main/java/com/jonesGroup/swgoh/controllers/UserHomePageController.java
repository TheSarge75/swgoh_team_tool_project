package com.jonesGroup.swgoh.controllers;

import com.jonesGroup.swgoh.models.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserHomePageController {

    @GetMapping("/userhomepage")
    public String showTheUserTheLoginPage(Model model){
        model.addAttribute("userprofile_object",new UserProfile("Padawan",""));
        return "lightside";
    }

    @PostMapping("/userhomepage")
    public String getUserHomePage(
            @RequestParam(value = "username_input", required = false, defaultValue = "defaultUsername") String username,
            @RequestParam(value = "password_input", required = false, defaultValue = "defaultpassword") String password,
            Model model){
        String pagename;
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        if (model.getAttribute("username").toString().equalsIgnoreCase("goodUsername") &&
            model.getAttribute("password").toString().equalsIgnoreCase("goodPassword")){
            model.addAttribute("user",new UserProfile(username,password));
            pagename = "userhomepage";
        } else {
            pagename = "loginerrorpage";
        }
        System.out.println(model.getAttribute("username"));
        System.out.println(model.getAttribute("password"));
        System.out.println(pagename);
        return pagename;
    }
}
