package com.kalinovna.biserinka.api.service;

import com.kalinovna.biserinka.api.model.Product;
import java.util.List;

public interface ProductService {

  List<Product> getAll();

  Product get(Long id);
}
