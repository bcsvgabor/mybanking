package com.myrepo.mybanking.controllers;

import com.myrepo.mybanking.exceptions.NotFoundException;
import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.services.BankUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BankUserService bankUserService;

    @GetMapping({"/", "/home"})
    public String homePage(@RequestParam(name = "username") String username, Model model) {

        if (username == null) {
            return "redirect:/login";
        }
        Optional<BankUser> bankUser = bankUserService.findByUsername(username);

        if (bankUser.isPresent()){
            model.addAttribute("bankUser", bankUser.get());
            return "index";
        } else {
            throw new NotFoundException("User not found.");
        }


//        Integer accountListSize = bankUserService.numberOfAccounts(bankUser);
//        model.addAttribute("numberOfAccounts", accountListSize);


    }
}
