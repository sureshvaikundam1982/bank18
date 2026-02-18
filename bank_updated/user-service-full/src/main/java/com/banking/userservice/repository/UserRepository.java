package com.banking.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
