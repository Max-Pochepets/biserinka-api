package com.kalinovna.biserinka.service;

import com.kalinovna.biserinka.model.Category;
import java.util.List;

public interface CategoryService {

  List<Category> getAll();

  Category get(Long id);
}
