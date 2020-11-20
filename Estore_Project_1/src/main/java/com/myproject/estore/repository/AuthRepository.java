package com.myproject.estore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.User;

public interface AuthRepository extends JpaRepository<AuthEntity, String> {
	Optional<AuthEntity> findByEmail(String email);

}
