package com.example.springbootdemo1.Repositories;

import com.example.springbootdemo1.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User,Integer> {

}
