package com.myrepo.mybanking.controllers;

import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.services.BankUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BankUserService bankUserService;

    @GetMapping({"/", "/home"})
    public String homePage(@ModelAttribute BankUser bankUser, Model model) {

        if (bankUser.getId() == null) {
            return "redirect:/login";
        }
        model.addAttribute("bankUser", bankUser);

//        Integer accountListSize = bankUserService.numberOfAccounts(bankUser);
//        model.addAttribute("numberOfAccounts", accountListSize);

        return "index";
    }
}
