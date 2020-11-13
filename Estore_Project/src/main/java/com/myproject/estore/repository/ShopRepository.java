package com.myproject.estore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.estore.dto.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	Optional<Shop> findByEmail(String email);
	public Shop findByemail(String email);
}
