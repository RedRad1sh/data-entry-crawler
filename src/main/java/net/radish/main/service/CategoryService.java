package net.radish.main.service;

import net.radish.main.model.Category;

import java.util.List;

public interface CategoryService {
    Category findOne(Long id);

    void save(Category category);

    void delete(Long id);

    List<Category> getAll();
}
