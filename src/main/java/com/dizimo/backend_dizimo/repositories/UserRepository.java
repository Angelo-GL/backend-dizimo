package com.dizimo.backend_dizimo.repositories;

import com.dizimo.backend_dizimo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
