package net.radish.crawler.service;

import lombok.extern.slf4j.Slf4j;
import net.radish.crawler.model.Category;
import net.radish.crawler.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getById(Long id) {
        log.info("IN CategoryServiceImplementation METHOD getById {}", id);
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category good) {
        log.info("IN CategoryServiceImplementation METHOD save {}", good);
        categoryRepository.save(good);
    }

    @Override
    public void delete(Long id) {
        log.info("IN CategoryServiceImplementation METHOD delete {}", id);
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        log.info("IN CategoryServiceImplementation METHOD getAll");
        return categoryRepository.findAll();
    }
}
