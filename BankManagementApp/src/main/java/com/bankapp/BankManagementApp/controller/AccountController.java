package com.bankapp.BankManagementApp.controller;

import com.bankapp.BankManagementApp.entity.Account;
import com.bankapp.BankManagementApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // create the account
    @PostMapping("/create")
    public Account CreateAccount(@RequestBody Account account) {
        Account account1 = accountService.createAccount(account);
        return account1;
    }

    @GetMapping("{accountNumber}")
    public Account GetAccount(@PathVariable Long accountNumber) {
        Account account = accountService.getAccount(accountNumber);
        return account;
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        List<Account> allAccounts= accountService.getAllAccounts();
        return allAccounts;
    }

    @PutMapping("/deposite/{accountNumber}/{amount}")
    public Account deposite(@PathVariable Long accountNumber, @PathVariable Double amount) {
        Account account = accountService.depositMoney(accountNumber, amount);
        return account;
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdraw(@PathVariable Long accountNumber, @PathVariable Double amount) {
        Account account = accountService.withdrawMoney(accountNumber, amount);
        return account;
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> delete(@PathVariable Long accountNumber) {
        accountService.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account deleted successfully");
    }
}
