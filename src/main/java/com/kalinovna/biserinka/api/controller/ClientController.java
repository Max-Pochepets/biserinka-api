package com.kalinovna.biserinka.api.controller;

import com.kalinovna.biserinka.api.dto.ClientDto;
import com.kalinovna.biserinka.api.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
  private final ClientService service;
  private final ModelMapper mapper;

  @GetMapping
  public List<ClientDto> getAllClients() {
    return service.getAll().stream().map(client -> mapper.map(client, ClientDto.class)).toList();
  }

  @GetMapping("/{id}")
  public ClientDto getClientById(@PathVariable Long id) {
    return mapper.map(service.get(id), ClientDto.class);
  }
}
