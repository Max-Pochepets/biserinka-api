package com.kalinovna.biserinka.service;

import com.kalinovna.biserinka.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getAll();

    Client get(Long id);

    Optional<Client> findByEmail(String email);
}
