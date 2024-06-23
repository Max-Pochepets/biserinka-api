package com.kalinovna.biserinka.api.repository;

import com.kalinovna.biserinka.api.model.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  Optional<Client> findByEmail(String email);
}
