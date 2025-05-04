package com.bankapp.BankManagementApp.service;

import com.bankapp.BankManagementApp.entity.Account;
import com.bankapp.BankManagementApp.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    @Override
    public Account getAccount(Long accountNumber) {
        Optional<Account> account= accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account not found");
        }
        Account account_found= account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> allAccounts=accountRepository.findAll();
        return allAccounts;
    }

    @Override
    public Account depositMoney(Long accountNumber, Double amount) {
        Optional<Account> account= accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account not found");
        }
        Account account_found= account.get();
        Double totalBalance= account_found.getAccount_balance()+amount;
        account_found.setAccount_balance(totalBalance);
        accountRepository.save(account_found);
        return account_found;
    }

    @Override
    public Account withdrawMoney(Long accountNumber, Double amount) {
        Optional<Account> account= accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account not found");
        }
        Account account_found= account.get();
        Double totalBalance= account_found.getAccount_balance()-amount;
        account_found.setAccount_balance(totalBalance);
        accountRepository.save(account_found);
        return account_found;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        getAccount(accountNumber);
        accountRepository.delete(getAccount(accountNumber));

    }
}
