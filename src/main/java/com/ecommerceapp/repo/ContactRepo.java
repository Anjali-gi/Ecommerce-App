package com.ecommerceapp.repo;


import com.ecommerceapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ContactRepo extends JpaRepository<Message, Long> {

}