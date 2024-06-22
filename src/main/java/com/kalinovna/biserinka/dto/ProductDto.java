package com.kalinovna.biserinka.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
}
