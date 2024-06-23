package com.kalinovna.biserinka.api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalinovna.biserinka.api.config.AppConfig;
import com.kalinovna.biserinka.api.dto.CategoryDto;
import com.kalinovna.biserinka.api.model.Category;
import com.kalinovna.biserinka.api.service.CategoryService;
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

@WebMvcTest(CategoryController.class)
@Import(CategoryController.class)
@ContextConfiguration(classes = {AppConfig.class})
class CategoryControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private CategoryService service;
  private static Category category;
  private static List<Category> categories;
  private static CategoryDto categoryDto;
  private static List<CategoryDto> categoryDtos;
  private static ObjectMapper jsonMapper;

  @BeforeAll
  static void beforeAll(@Autowired ModelMapper modelMapper) {
    category = new Category(1L, "Jewels", "Shiny", 1);
    categories = List.of(category);
    categoryDto = modelMapper.map(category, CategoryDto.class);
    categoryDtos = List.of(categoryDto);

    jsonMapper = new ObjectMapper();
  }

  @Test
  void getAllCategories() throws Exception {
    when(service.getAll()).thenReturn(categories);

    mockMvc
        .perform(get("/categories"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(jsonMapper.writeValueAsString(categoryDtos)));
  }

  @Test
  void getById() throws Exception {
    when(service.get(1L)).thenReturn(category);

    mockMvc
        .perform(get("/categories/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(jsonMapper.writeValueAsString(categoryDto)));
  }
}
