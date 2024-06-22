package com.kalinovna.biserinka.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalinovna.biserinka.config.AppConfig;
import com.kalinovna.biserinka.dto.ProductDto;
import com.kalinovna.biserinka.model.Product;
import com.kalinovna.biserinka.service.ProductService;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
@Import(ProductController.class)
@ContextConfiguration(classes = {AppConfig.class})
class ProductControllerTest {

  @Autowired private MockMvc mvc;
  @MockBean private ProductService productService;
  private static Product product;
  private static List<Product> products;
  private static ProductDto productDto;
  private static List<ProductDto> productDtos;
  private static ObjectMapper jsonMapper;

  @BeforeAll
  static void beforeAll(@Autowired ModelMapper modelMapper) {
    product = new Product(1L, "Lariat", "Pretty", new BigDecimal("25.00"));
    products = List.of(product);
    productDto = modelMapper.map(product, ProductDto.class);
    productDtos =
        products.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();

    jsonMapper = new ObjectMapper();
  }

  @Test
  void getAllProducts() throws Exception {
    when(productService.getAll()).thenReturn(products);

    mvc.perform(get("/products"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(jsonMapper.writeValueAsString(productDtos)));
  }

  @Test
  void getProductById() throws Exception {
    when(productService.get(1L)).thenReturn(product);

    mvc.perform(get("/products/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(jsonMapper.writeValueAsString(productDto)));
  }
}
