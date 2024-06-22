package com.kalinovna.biserinka.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import com.kalinovna.biserinka.model.Category;
import com.kalinovna.biserinka.repository.CategoryRepository;
import com.kalinovna.biserinka.service.impl.CategoryServiceImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

  @Mock private CategoryRepository repository;
  @InjectMocks private CategoryServiceImpl service;

  private static Category category;
  private static List<Category> categories;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    category = new Category(1L, "Jewels", "Shiny", 1);
    categories = List.of(new Category(1L, "Jewels", "Shiny", 1));
  }

  @Test
  void getAll() {
    when(repository.findAll()).thenReturn(categories);

    assertSame(categories, service.getAll());
    verify(repository, times(1)).findAll();
  }

  @Test
  void get() {
    when(repository.getReferenceById(1L)).thenReturn(category);

    assertSame(category, service.get(1L));
    verify(repository, times(1)).getReferenceById(1L);
  }
}
