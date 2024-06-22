package com.kalinovna.biserinka.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import com.kalinovna.biserinka.model.Product;
import com.kalinovna.biserinka.repository.ProductRepository;
import com.kalinovna.biserinka.service.impl.ProductServiceImpl;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @Mock private ProductRepository repository;
  @InjectMocks private ProductServiceImpl service;

  private static Product product;
  private static List<Product> products;

  @BeforeAll
  static void beforeAll() {
    product = new Product(1L, "Lariat", "Pretty", new BigDecimal("25.00"));
    products = List.of(product);
  }

  @Test
  void getAll() {
    when(repository.findAll()).thenReturn(products);

    assertSame(products, service.getAll());
    verify(repository, times(1)).findAll();
  }

  @Test
  void get() {
    when(repository.getReferenceById(1L)).thenReturn(product);

    assertSame(product, service.get(1L));
    verify(repository, times(1)).getReferenceById(1L);
  }
}
