package com.ecommerceapp.repo;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerceapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	public User findByEmail(String email);


	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE users AUTO_INCREMENT = (SELECT MAX(id) + 1 FROM users)", nativeQuery = true)
	void resetUserSequence();
}
