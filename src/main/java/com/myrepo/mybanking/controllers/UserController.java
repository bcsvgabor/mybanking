package com.myrepo.mybanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

    @GetMapping("/login")
    public String loginForm(Model model){

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute  )

}
