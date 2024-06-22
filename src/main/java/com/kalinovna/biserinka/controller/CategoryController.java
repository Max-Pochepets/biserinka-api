package com.kalinovna.biserinka.controller;

import com.kalinovna.biserinka.dto.CategoryDto;
import com.kalinovna.biserinka.model.Category;
import com.kalinovna.biserinka.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService service;
  private final ModelMapper mapper;

  @GetMapping
  @ResponseBody
  public List<CategoryDto> getAllCategories() {
    return service.getAll().stream()
        .map(category -> mapper.map(category, CategoryDto.class))
        .toList();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public CategoryDto getById(@PathVariable Long id) {
    Category category = service.get(id);
    return mapper.map(category, CategoryDto.class);
  }
}
