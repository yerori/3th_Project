package com.myproject.estore.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproject.estore.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	@Query(value="select * from user u where u.email=?1",  nativeQuery=true)
	User findByUseremail(String email);
}
