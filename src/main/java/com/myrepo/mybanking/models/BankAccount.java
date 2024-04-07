package com.myrepo.mybanking.models;

import com.myrepo.mybanking.utils.AccountNumberGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private String accountName;
    private Integer accountBalance;

    @ManyToOne
    private BankUser bankUser;

    public void startAccount(BankUser bankUser) {
        AccountNumberGenerator generator = new AccountNumberGenerator();

        this.accountNumber = generator.generateNumber(id);
        this.accountBalance = 0;
        this.bankUser = bankUser;
        this.accountName = "basic";
    }

    public void createAccount(BankUser bankUser, String accountName){

        AccountNumberGenerator generator = new AccountNumberGenerator();

        this.accountNumber = generator.generateNumber(id);
        this.accountBalance = 0;
        this.bankUser = bankUser;
        this.accountName = accountName;
    }

}

