package com.example.springbootdemo1.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Refund
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer refundId;
    private Double amount;


    @OneToOne
    @JoinColumn(name = "transId")
    private Transaction transaction;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User userRef;

}
