package net.radish.crawler.service;

import net.radish.crawler.model.Good;

import java.util.List;

public interface GoodService {
    Good getById(Long id);

    void save(Good good);

    void delete(Long id);

    List<Good> getAll();

}
