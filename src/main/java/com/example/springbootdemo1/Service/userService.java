package com.example.springbootdemo1.Service;


import com.example.springbootdemo1.Models.Transaction;
import com.example.springbootdemo1.Models.User;
import com.example.springbootdemo1.Repositories.transactionRepo;
import com.example.springbootdemo1.Repositories.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class userService
{
     @Autowired
     private userRepo userrepo;

     @Autowired
     private transactionRepo transactionrepo;
    public String addUser(User user)
    {
          userrepo.save(user);
          return "added Successfully";
    }
    public String deleteFailedTransactions(Integer userId)
    {
        Optional<User> optionalUser = userrepo.findById(userId);
        if(optionalUser.isEmpty()) return "invalid userId";

        List<Transaction> optionalTransaction = transactionrepo.findAll();
        for(int i=0; i<optionalTransaction.size(); i++)
        {
            Transaction t = optionalTransaction.get(i);
            if(t.getUser() != null && t.getUser().getUserId() == userId && t.getStatus() == false)
            {
                 t.setUser(null);
                 transactionrepo.save(t);


            }
        }
       return "deleted successfully";

    }

}
