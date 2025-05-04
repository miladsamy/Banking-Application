package com.bankapp.BankManagementApp.repo;

import com.bankapp.BankManagementApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
