package com.example.springbootdemo1.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private String accNo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Transaction>transactionList = new ArrayList<>();

    @OneToMany(mappedBy = "userRef", cascade = CascadeType.ALL)
    List<Refund>refundList = new ArrayList<>();

}
