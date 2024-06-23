package com.kalinovna.biserinka.api.controller;

import com.kalinovna.biserinka.api.dto.ProductDto;
import com.kalinovna.biserinka.api.model.Product;
import com.kalinovna.biserinka.api.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService service;
  private final ModelMapper mapper;

  @GetMapping
  @ResponseBody
  public List<ProductDto> getAllProducts() {
    return service.getAll().stream().map(product -> mapper.map(product, ProductDto.class)).toList();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ProductDto getProductById(@PathVariable Long id) {
    Product product = service.get(id);
    return mapper.map(product, ProductDto.class);
  }
}
