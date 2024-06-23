package com.kalinovna.biserinka.api.controller;

import com.kalinovna.biserinka.api.dto.LoginDto;
import com.kalinovna.biserinka.api.service.ClientService;
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
    return null;
  }
}
