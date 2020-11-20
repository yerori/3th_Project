package com.myproject.estore.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.estore.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	public User findByemail(String email);
}
