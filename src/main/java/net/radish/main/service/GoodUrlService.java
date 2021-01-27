package net.radish.main.service;

import net.radish.main.model.GoodUrl;

import java.util.List;

public interface GoodUrlService {
    GoodUrl findOne(Long id);

    void save(GoodUrl goodUrl);

    void delete(Long id);

    List<GoodUrl> getAll();
}
