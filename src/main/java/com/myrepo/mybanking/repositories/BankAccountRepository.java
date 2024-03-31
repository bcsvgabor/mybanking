package com.myrepo.mybanking.repositories;

import com.myrepo.mybanking.models.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    void saveBankAccount(BankAccount bankAccount);
}
