package com.kalinovna.biserinka.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClientDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String address;
}
