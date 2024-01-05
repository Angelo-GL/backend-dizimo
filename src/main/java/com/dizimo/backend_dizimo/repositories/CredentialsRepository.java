package com.dizimo.backend_dizimo.repositories;

import com.dizimo.backend_dizimo.entities.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
}
