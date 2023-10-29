package com.dizimo.backend_dizimo.repositories;

import com.dizimo.backend_dizimo.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCpf (String cpf);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
