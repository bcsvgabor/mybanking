package com.myrepo.mybanking.services;

import com.myrepo.mybanking.models.BankUser;

import java.util.Optional;

public interface BankUserService {

    Optional<BankUser> findById(Long id);

    void saveBankUser(BankUser bankUser);

    void hashBankUserPassword(BankUser bankUser);
    Optional<BankUser> findByUsername(String username);
    public boolean isUserTableEmpty();

    boolean validateHash(BankUser bankUser, String password);

    Integer numberOfAccounts(BankUser bankUser);

    Integer totalBalance(BankUser bankUser);
}
