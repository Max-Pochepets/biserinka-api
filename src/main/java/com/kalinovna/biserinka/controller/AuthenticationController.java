package com.kalinovna.biserinka.controller;

import com.kalinovna.biserinka.dto.LoginDto;
import com.kalinovna.biserinka.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {
    private final ClientService service;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {

    }
}
