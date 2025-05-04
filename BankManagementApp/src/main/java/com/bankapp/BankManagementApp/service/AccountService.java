package com.bankapp.BankManagementApp.service;

import com.bankapp.BankManagementApp.entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccount(Long accountNumber);
    public List<Account> getAllAccounts();
    public Account depositMoney(Long accountNumber, Double amount);
    public Account withdrawMoney(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
}
