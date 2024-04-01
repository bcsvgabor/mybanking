package com.myrepo.mybanking.models;

import com.myrepo.mybanking.utils.AccountNumberGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class BankAccount {

    @Id
    private Long id;
    private Long accountNumber;
    private Integer accountBalance;

    @ManyToOne
    private BankUser bankUser;

    public void startAccount(BankUser bankUser) {
        AccountNumberGenerator generator = new AccountNumberGenerator();

        this.accountNumber = generator.generateNumber(id);
        this.accountBalance = 0;
        this.bankUser = bankUser;
    }

}

