package net.radish.main.service;

import net.radish.main.model.Shop;

import java.util.List;

public interface ShopService {
    Shop findOne(Long id);

    void save(Shop shop);

    void delete(Long id);

    List<Shop> getAll();
}
