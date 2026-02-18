package com.banking.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.accountservice.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
