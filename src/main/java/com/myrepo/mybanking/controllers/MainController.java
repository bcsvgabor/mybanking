package com.myrepo.mybanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping({"/", "/home"})
    public String homePage(@RequestParam String username, Model model) {

        if (username == null){
            return "redirect:/login";
        }
        return "index";
    }
}
