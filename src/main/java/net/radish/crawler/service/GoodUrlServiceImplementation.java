package net.radish.crawler.service;

import lombok.extern.slf4j.Slf4j;
import net.radish.crawler.model.GoodUrl;
import net.radish.crawler.model.Shop;
import net.radish.crawler.repository.GoodRepository;
import net.radish.crawler.repository.GoodUrlRepository;
import net.radish.crawler.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodUrlServiceImplementation implements GoodUrlService {

    @Autowired
    GoodUrlRepository goodUrlRepository;

    @Override
    public GoodUrl getById(Long id) {
        log.info("IN GoodUrlServiceImplementation METHOD getById {}", id);
        return goodUrlRepository.findById(id).orElse(null);
    }

    @Override
    public void save(GoodUrl goodUrl) {
        log.info("IN GoodUrlServiceImplementation METHOD save {}", goodUrl);
        goodUrlRepository.save(goodUrl);
    }

    @Override
    public void delete(Long id) {
        log.info("IN GoodUrlServiceImplementation METHOD delete {}", id);
        goodUrlRepository.deleteById(id);
    }

    @Override
    public List<GoodUrl> getAll() {
        log.info("IN GoodUrlServiceImplementation METHOD getAll");
        return goodUrlRepository.findAll();
    }
}
