package com.myrepo.mybanking.services;

import com.myrepo.mybanking.models.BankAccount;
import com.myrepo.mybanking.models.BankUser;

public interface BankAccountService {

    void saveBankAccount(BankAccount bankAccount);

    void setupBankAccount(BankUser bankUser);

    void createBankAccount(BankUser bankUser, String accountName);

}
