package com.kalinovna.biserinka.service.impl;

import com.kalinovna.biserinka.model.Product;
import com.kalinovna.biserinka.repository.ProductRepository;
import com.kalinovna.biserinka.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;

  @Override
  public List<Product> getAll() {
    return repository.findAll();
  }

  @Override
  public Product get(Long id) {
    return repository.getReferenceById(id);
  }
}
