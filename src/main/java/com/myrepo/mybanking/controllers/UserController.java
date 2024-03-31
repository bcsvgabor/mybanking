package com.myrepo.mybanking.controllers;

import com.myrepo.mybanking.models.BankAccount;
import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.services.BankUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class UserController {

    private BankUserService bankUserService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("bankUser", new BankUser());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute BankUser bankUser, Model model) {
        Optional<BankUser> user = bankUserService.findById(bankUser.getId());

        if (!user.isPresent() || !bankUser.getPassword().equals(user.get().getPassword())) {
            model.addAttribute("loginError", "Invalid username or password");
            return "/login";
        } else {
            model.addAttribute("bankUser", user.get());
            return String.format("redirect:/?username=%s", user.get().getUsername());
        }

    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("bankuser", new BankUser());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute BankUser bankUser, Model model) {

        if (!bankUser.getPassword().equals(bankUser.getConfirmpassword())) {
            model.addAttribute("registerError", "Passwords does not match.");
            return "/register";
        }

        bankUserService.saveBankUser(bankUser);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankUser(bankUser);

        return "login";
    }

}
