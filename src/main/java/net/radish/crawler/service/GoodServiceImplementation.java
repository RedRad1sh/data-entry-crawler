package net.radish.crawler.service;

import lombok.extern.slf4j.Slf4j;
import net.radish.crawler.model.Good;
import net.radish.crawler.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodServiceImplementation implements GoodService {

    @Autowired
    GoodRepository goodRepository;

    @Override
    public Good getById(Long id) {
        log.info("IN GoodServiceImplementation METHOD getById {}", id);
        return goodRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Good good) {
        log.info("IN GoodServiceImplementation METHOD save {}", good);
        goodRepository.save(good);
    }

    @Override
    public void delete(Long id) {
        log.info("IN GoodServiceImplementation METHOD delete {}", id);
        goodRepository.deleteById(id);
    }

    @Override
    public List<Good> getAll() {
        log.info("IN GoodServiceImplementation METHOD getAll");
        return goodRepository.findAll();
    }
}
