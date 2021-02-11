package com.jonesGroup.swgoh.controllers;

import com.jonesGroup.swgoh.models.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DarksideController {

    @GetMapping("/darkside")
    public String getDarksidePage(@RequestParam(value = "name",defaultValue = "Apprentice") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("default_userprofile_object", UserProfile.getProfile());
        return "darkside";
    }

}
