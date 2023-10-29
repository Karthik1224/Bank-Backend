package com.example.springbootdemo1.Controllers;


import com.example.springbootdemo1.Models.Transaction;
import com.example.springbootdemo1.Models.User;
import com.example.springbootdemo1.Service.transactionService;
import com.example.springbootdemo1.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo1")
public class Controller {

        @Autowired
        private userService userservice;

        @Autowired
        private transactionService transactionservice;
        @PostMapping("/addUser")
        public String addUser(@RequestBody User user)
        {
             return userservice.addUser(user);
        }

        @PostMapping("/addTransaction")
        public String addTransaction(@RequestBody Transaction obj)
        {
                return transactionservice.addTransaction(obj);
        }

        @PostMapping("/transMap")
        public String UserAndTransMapping(@RequestParam Integer userId, @RequestParam Integer transId)
        {
               return transactionservice.UserAndTransMapping(userId,transId);
        }

        @GetMapping("/getSuccessTransactions")
        public int successTransactions(@RequestParam Integer userId)
        {
                return transactionservice.successTransactions(userId);
        }

        @DeleteMapping("/deleteFailedTrans")
        public String deleteFailedTransactions(@RequestParam Integer userId)
        {
                return userservice.deleteFailedTransactions(userId);
        }

        @GetMapping("/transListSize")
        public int getTransListSize(@RequestParam Integer userId)
        {
                return transactionservice.getTransListSize(userId);
        }

}
