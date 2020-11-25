package net.radish.crawler.service;

import net.radish.crawler.model.GoodUrl;

import java.util.List;

public interface GoodUrlService {
    GoodUrl getById(Long id);

    void save(GoodUrl goodUrl);

    void delete(Long id);

    List<GoodUrl> getAll();
}
