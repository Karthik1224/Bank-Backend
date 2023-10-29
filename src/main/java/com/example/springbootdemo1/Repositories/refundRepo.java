package com.example.springbootdemo1.Repositories;

import com.example.springbootdemo1.Models.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface refundRepo extends JpaRepository<Refund,Integer>{
}
