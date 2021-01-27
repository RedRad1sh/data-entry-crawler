package net.radish.main.service;

import lombok.extern.slf4j.Slf4j;
import net.radish.main.model.Good;
import net.radish.main.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodServiceImplementation implements GoodService {

    @Autowired
    GoodRepository goodRepository;

    @Override
    public Good findOne(Long id) {
        log.info("IN GoodServiceImplementation METHOD getById {}", id);
        return goodRepository.findById(id).get();
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
