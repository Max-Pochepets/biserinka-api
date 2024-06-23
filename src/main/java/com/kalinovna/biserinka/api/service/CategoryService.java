package com.kalinovna.biserinka.api.service;

import com.kalinovna.biserinka.api.model.Category;
import java.util.List;

public interface CategoryService {

  List<Category> getAll();

  Category get(Long id);
}
