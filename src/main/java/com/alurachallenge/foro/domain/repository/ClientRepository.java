package com.alurachallenge.foro.domain.repository;

import com.alurachallenge.foro.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClientRepository extends JpaRepository<Client, Long> {
    UserDetails findByUserName(String username);
}
