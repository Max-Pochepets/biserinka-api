package com.kalinovna.biserinka.controller;

import com.kalinovna.biserinka.dto.ClientDto;
import com.kalinovna.biserinka.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return service.getAll().stream()
                .map(client -> mapper.map(client, ClientDto.class))
                .toList();
    }

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) {
        return mapper.map(service.get(id), ClientDto.class);
    }

}
