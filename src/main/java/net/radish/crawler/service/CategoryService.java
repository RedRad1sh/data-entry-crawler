package net.radish.crawler.service;

import net.radish.crawler.model.Category;

import java.util.List;

public interface CategoryService {
    Category getById(Long id);

    void save(Category category);

    void delete(Long id);

    List<Category> getAll();
}
