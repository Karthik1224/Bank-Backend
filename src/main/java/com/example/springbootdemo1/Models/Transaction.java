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
public class Transaction
{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer transId;
     private Double amount;
     private Boolean status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Refund refund;

}
