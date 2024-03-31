package com.myrepo.mybanking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class BankAccount {

    @Id
    private Long id;
    private Long accountNumber;
    private Integer accountBalance;

    @ManyToOne
    private BankUser bankUser;

}
