package com.myrepo.mybanking.repositories;

import com.myrepo.mybanking.models.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Long> {
    Optional<BankUser> findById(@NonNull Long id);

    Optional<BankUser> findBankUserByUsername(BankUser bankUser);
}
