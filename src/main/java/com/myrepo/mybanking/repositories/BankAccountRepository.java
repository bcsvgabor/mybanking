package com.myrepo.mybanking.repositories;

import com.myrepo.mybanking.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Optional<BankAccount> findBankAccountByAccountName(String accountName);
}
