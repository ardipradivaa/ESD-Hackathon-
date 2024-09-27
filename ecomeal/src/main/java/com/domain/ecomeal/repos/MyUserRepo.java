package com.domain.ecomeal.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.ecomeal.models.entities.MyUser;

public interface MyUserRepo extends JpaRepository<MyUser, Long> {

    Optional<MyUser> findByEmail(String email);
    
}
