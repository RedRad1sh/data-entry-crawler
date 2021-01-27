package net.radish.main.service;

import lombok.extern.slf4j.Slf4j;
import net.radish.main.model.GoodUrl;
import net.radish.main.repository.GoodUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodUrlServiceImplementation implements GoodUrlService {

    @Autowired
    GoodUrlRepository goodUrlRepository;

    @Override
    public GoodUrl findOne(Long id) {
        log.info("IN GoodUrlServiceImplementation METHOD getById {}", id);
        return goodUrlRepository.findById(id).get();
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
