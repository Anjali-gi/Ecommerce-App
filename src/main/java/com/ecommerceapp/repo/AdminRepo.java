package com.ecommerceapp.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerceapp.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

	public Admin findByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE admins AUTO_INCREMENT = (SELECT MAX(id) + 1 FROM admins)", nativeQuery = true)
	void resetAdminSequence();

}
