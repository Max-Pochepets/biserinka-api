package com.kalinovna.biserinka.service;

import com.kalinovna.biserinka.model.Product;
import java.util.List;

public interface ProductService {

  List<Product> getAll();

  Product get(Long id);
}
