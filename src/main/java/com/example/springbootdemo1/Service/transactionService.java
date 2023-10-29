package com.example.springbootdemo1.Service;


import com.example.springbootdemo1.Models.Transaction;
import com.example.springbootdemo1.Models.User;
import com.example.springbootdemo1.Repositories.transactionRepo;
import com.example.springbootdemo1.Repositories.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class transactionService
{

      @Autowired
      private transactionRepo transactionrepo;

      @Autowired
      private userRepo userrepo;
      public String addTransaction(Transaction obj)
      {
          transactionrepo.save(obj);

          return "added successfully";
      }

    public String UserAndTransMapping(Integer userId,Integer transId)
    {
        Optional<User>optionalUser = userrepo.findById(userId);
        if(optionalUser.isEmpty()) return "invalid userId";

        Optional<Transaction>optionalTransaction = transactionrepo.findById(transId);
        if(optionalTransaction.isEmpty()) return "invalid transId";

        User userObj = optionalUser.get();
        Transaction transObj = optionalTransaction.get();

        List<Transaction> list = userObj.getTransactionList();
        list.add(transObj);
        userObj.setTransactionList(list);
        transObj.setUser(userObj);
        userrepo.save(userObj);
        return "mapped successfully";

    }

    public int successTransactions(Integer userId)
    {
        Optional<User>optionalUser = userrepo.findById(userId);
        if(optionalUser.isEmpty()) return 0;
        int count=0;
        User userObj = optionalUser.get();
        List<Transaction> list = userObj.getTransactionList();
        for(Transaction t:list)
        {
            if(t.getStatus()==true)
            {
                count++;
            }
        }
        return count;
    }

    public int getTransListSize(Integer userId)
    {
        Optional<User> optionalUsery = userrepo.findById(userId);
        User user = optionalUsery.get();
        List<Transaction>userlist = user.getTransactionList();
        return userlist.size();
    }
}
