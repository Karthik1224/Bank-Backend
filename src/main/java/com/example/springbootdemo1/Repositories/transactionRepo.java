package com.example.springbootdemo1.Repositories;

import com.example.springbootdemo1.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface transactionRepo extends JpaRepository<Transaction,Integer> {
}
