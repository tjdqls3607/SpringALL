package com.mycom.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycom.myapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
