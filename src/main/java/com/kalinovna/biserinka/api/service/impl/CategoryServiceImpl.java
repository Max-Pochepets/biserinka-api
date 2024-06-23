package com.kalinovna.biserinka.api.service.impl;

import com.kalinovna.biserinka.api.model.Category;
import com.kalinovna.biserinka.api.repository.CategoryRepository;
import com.kalinovna.biserinka.api.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository repository;

  @Override
  public List<Category> getAll() {
    return repository.findAll();
  }

  @Override
  public Category get(Long id) {
    return repository.getReferenceById(id);
  }
}
