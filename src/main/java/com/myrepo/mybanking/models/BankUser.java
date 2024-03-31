package com.myrepo.mybanking.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.Set;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class BankUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String confirmpassword;
    private String name;

    @OneToMany
    private Set<BankAccount> bankAccountList;
}
