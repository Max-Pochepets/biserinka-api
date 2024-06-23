package com.kalinovna.biserinka.api.service.impl;

import com.kalinovna.biserinka.api.model.Client;
import com.kalinovna.biserinka.api.repository.ClientRepository;
import com.kalinovna.biserinka.api.service.ClientService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
  private final ClientRepository clientRepository;

  @Override
  public List<Client> getAll() {
    return clientRepository.findAll();
  }

  @Override
  public Client get(Long id) {
    return clientRepository.getReferenceById(id);
  }

  @Override
  public Optional<Client> findByEmail(String email) {
    return clientRepository.findByEmail(email);
  }
}
