package com.akinzo.Walk2WealthUserService.repository;

import com.akinzo.Walk2WealthUserService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);

    Users findByUsername(String username);
}
