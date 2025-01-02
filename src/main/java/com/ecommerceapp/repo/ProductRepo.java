package com.ecommerceapp.repo;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerceapp.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	public Product findByName(String name);


	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE products AUTO_INCREMENT = (SELECT MAX(id) + 1 FROM products)", nativeQuery = true)
	void resetUserSequence();
}


