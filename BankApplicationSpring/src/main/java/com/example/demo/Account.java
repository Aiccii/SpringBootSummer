package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Account {
/*
Account Entity represents a bank account with properties like ID,
account holder name, and balance. It uses JPA annotations to define the entity
and its mapping to the database.
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String userName;
    private double Balance;

}
