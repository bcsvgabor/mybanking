package com.myrepo.mybanking.controllers;

import com.myrepo.mybanking.exceptions.NotFoundException;
import com.myrepo.mybanking.models.BankAccount;
import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.services.BankAccountService;
import com.myrepo.mybanking.services.BankUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BankUserService bankUserService;
    private final BankAccountService bankAccountService;

    @GetMapping({"/", "/home"})
    public String homePage(@RequestParam(name = "username") String username, Model model) {

        if (username == null) {
            return "redirect:/login";
        }
        Optional<BankUser> bankUser = bankUserService.findByUsername(username);

        if (bankUser.isPresent()) {
            model.addAttribute("bankUser", bankUser.get());
            return "index";
        } else {
            throw new NotFoundException("User not found.");
        }


//        Integer accountListSize = bankUserService.numberOfAccounts(bankUser);
//        model.addAttribute("numberOfAccounts", accountListSize);
    }

    @GetMapping("/balance")
    public String balancePage(@RequestParam(name = "username") String username, Model model) {

        Optional<BankUser> bankUser = bankUserService.findByUsername(username);

        if (bankUser.isPresent()) {
            model.addAttribute("bankUser", bankUser.get());
            model.addAttribute("totalBalance", bankUserService.totalBalance(bankUser.get()));
            return "/balance";
        } else {
            throw new NotFoundException("User not found.");
        }
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(name = "username") String username, Model model){

        Optional<BankUser> bankUser = bankUserService.findByUsername(username);

        if (bankUser.isPresent()) {

            model.addAttribute("bankUser", bankUser.get());
            BankAccount bankAccount = new BankAccount();
            model.addAttribute("bankAccount", bankAccount);
            return "/create";

        } else {
            throw new NotFoundException("User not found.");
        }
    }

    @PostMapping("/create")
    public String create(@RequestParam(name = "username") String username,
                         @ModelAttribute BankAccount bankAccount,
                         Model model){

        Optional<BankUser> bankUser = bankUserService.findByUsername(username);

        if (bankUser.isPresent()) {

            if(bankAccount.getAccountName().isBlank()){
                model.addAttribute("loginError", "Fill out Account Name to create bank account.");

                return String.format("redirect:/create/?username=%s", username);
            }

            bankAccountService.createBankAccount(bankUser.get(), bankAccount.getAccountName());

            return String.format("redirect:/?username=%s", username);

        } else {
            throw new NotFoundException("User not found.");
        }
    }

    @GetMapping("/deposit")
    public String depositPage(@RequestParam(name = "username") String username, Model model){

        Optional<BankUser> bankUser = bankUserService.findByUsername(username);

        if (bankUser.isPresent()) {

            model.addAttribute("bankUser", bankUser.get());

            return "/deposit";
        } else {
            throw new NotFoundException("User not found.");
        }

    }
}
