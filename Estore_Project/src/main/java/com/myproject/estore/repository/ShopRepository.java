package com.myproject.estore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproject.estore.dto.Shop;
import com.myproject.estore.dto.User;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	Optional<Shop> findByEmail(String email);
	@Query(value="select * from shop s where s.email=?1", nativeQuery=true)
	Shop findByShopemail(String email);
}
