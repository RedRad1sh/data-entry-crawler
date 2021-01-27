package net.radish.main.service;

import net.radish.main.model.Good;

import java.util.List;

public interface GoodService {
    Good findOne(Long id);

    void save(Good good);

    void delete(Long id);

    List<Good> getAll();

}
