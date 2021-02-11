package com.jonesGroup.swgoh.controllers;

import com.jonesGroup.swgoh.models.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LightsideController {

    @GetMapping("/lightside")
    public String getLightsidePage(Model model){
        model.addAttribute("userprofile_object",new UserProfile("Padawan",""));
        return "lightside";
    }
}
