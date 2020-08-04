package com.jonesGroup.swgoh.controllers;

import com.jonesGroup.swgoh.controllers.tools.GearPieceResolver_Tool;
import com.jonesGroup.swgoh.models.Hero;
import com.jonesGroup.swgoh.models.Manufacturer;
import com.jonesGroup.swgoh.models.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageNavigationController {

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("pageTitle","Jones SWGoH Team Tool - Home page");
        return "index";
    }

    @RequestMapping("/userProfile")
    public String getMyUserProfile(Model model){
        model.addAttribute("userProfile", UserProfile.getProfile());
        return "userProfile/userProfile";
    }

    @RequestMapping("/myHeroes")
    public String getAllMyHeroes(Model model){
        model.addAttribute("heroes", Hero.getAllHeroes());
        return "teams/myHeroes";
    }

    @RequestMapping("/squadArena_team")
    public String getMySquadArenaTeam(Model model){
        model.addAttribute("squadArena_team", Hero.getMySquadArenaTeam());
        return "teams/myHeroes";
    }

    @RequestMapping("/gearPieceResolver")
    public String launchTheGearPieceResolver(Model model){
        model.addAttribute("gearPieceResolver_tool", new GearPieceResolver_Tool());
        return "tools/gearPieceResolver";
    }

    @RequestMapping("/manufacturers")
    public String showAllManufacturers(Model model){
        model.addAttribute("manufacturersList", Manufacturer.getAllManufacturers());
        return "manufacturers/manufacturers";
    }
}
