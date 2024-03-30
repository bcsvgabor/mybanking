package com.myrepo.mybanking.controllers;

import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.repositories.BankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequiredArgsConstructor
public class UserController {

    private BankUserRepository bankUserRepository;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("bankUser", new BankUser());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute BankUser bankUser, Model model){
        BankUser user = service(bankUser.getId());
    }

}
