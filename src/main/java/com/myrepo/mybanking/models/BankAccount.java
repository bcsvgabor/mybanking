package com.myrepo.mybanking.models;

import com.myrepo.mybanking.utils.AccountNumberGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankAccount {

    @Id
    private Long id;
    private Long accountNumber;
    private Integer accountBalance;

    @ManyToOne
    private BankUser bankUser;

    public BankAccount(){
        AccountNumberGenerator generator = new AccountNumberGenerator();

        this.accountNumber = generator.generateNumber(id);
    }

}

