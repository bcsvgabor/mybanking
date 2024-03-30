package com.myrepo.mybanking.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class BankUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private String name;
}
