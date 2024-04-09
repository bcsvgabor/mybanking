package com.myrepo.mybanking.services;

import com.myrepo.mybanking.models.BankAccount;
import com.myrepo.mybanking.models.BankUser;

import java.util.Optional;

public interface BankAccountService {

    void saveBankAccount(BankAccount bankAccount);

    void setupBankAccount(BankUser bankUser);

    void createBankAccount(BankUser bankUser, String accountName);

    void depositBankAccount(BankAccount bankAccount, Integer amount);

    Optional<BankAccount> findBankAccountByName(String accountName);

    String printBalance(BankAccount bankAccount);

    boolean balanceIsNotEnaugh(BankAccount bankAccount, Integer amount);

    void withdrawBankAccount(BankAccount bankAccount, Integer amount);
}
