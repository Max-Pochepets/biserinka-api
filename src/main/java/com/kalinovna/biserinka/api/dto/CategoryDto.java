package com.kalinovna.biserinka.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
  private Long id;
  private String name;
  private String description;
  private Integer position;
}
