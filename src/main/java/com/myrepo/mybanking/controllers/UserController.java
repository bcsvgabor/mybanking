package com.myrepo.mybanking.controllers;

import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.services.BankAccountService;
import com.myrepo.mybanking.services.BankUserService;
import com.myrepo.mybanking.utils.PasswordValidatorUtil;
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

    private final BankUserService bankUserService;
    private final BankAccountService bankAccountService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("bankUser", new BankUser());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute BankUser bankUser, Model model) {

        Optional<BankUser> user = bankUserService.findByUsername(bankUser.getUsername());

        if (user.isPresent()) {

            if (!bankUserService.validateHash(user.get(), bankUser.getPassword())) {

                model.addAttribute("loginError", "Invalid password.");
                return "/login";
            }

            model.addAttribute("bankUser", user.get());
//            return "redirect:/";
            return String.format("redirect:/?username=%s", user.get().getUsername());

        } else {

            model.addAttribute("loginError", "Invalid username.");
            return "/login";
        }

    }

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("bankUser", new BankUser());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute BankUser bankUser, Model model) {

        if (bankUser.getPassword().isBlank()
                || bankUser.getConfirmpassword().isBlank()
                || bankUser.getName().isBlank()
                || bankUser.getUsername().isBlank()) {

            model.addAttribute("registerError", "Please fill out all the fields.");
            return "/register";
        }

        if (!bankUser.getPassword().equals(bankUser.getConfirmpassword())) {
            model.addAttribute("registerError", "Passwords does not match.");
            return "/register";
        }

        if (bankUserService.isUserTableEmpty()) {
            model.addAttribute("registerError", "Username is already exist. Please log in.");
            return "/register";
        }

        if (!PasswordValidatorUtil.isProdPasswordValid(bankUser.getPassword())) {
            model.addAttribute("registerError", "Passwords is too weak.");
            return "/register";
        }

        bankUserService.hashBankUserPassword(bankUser);
        bankAccountService.setupBankAccount(bankUser);

        return "redirect:/login";
    }


}
