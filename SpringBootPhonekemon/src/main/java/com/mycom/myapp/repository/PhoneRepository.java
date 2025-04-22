package com.mycom.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.myapp.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByNameContaining(String keyword);
}
