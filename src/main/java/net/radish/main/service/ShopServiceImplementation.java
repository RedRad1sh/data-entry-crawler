package net.radish.main.service;

import lombok.extern.slf4j.Slf4j;
import net.radish.main.model.Shop;
import net.radish.main.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShopServiceImplementation implements ShopService {

    @Autowired
    ShopRepository shopRepository;

    @Override
    public Shop findOne(Long id) {
        log.info("IN ShopServiceImplementation METHOD getById {}", id);
        return shopRepository.findById(id).get();
    }

    @Override
    public void save(Shop shop) {
        log.info("IN ShopServiceImplementation METHOD save {}", shop);
        shopRepository.save(shop);
    }

    @Override
    public void delete(Long id) {
        log.info("IN ShopServiceImplementation METHOD delete {}", id);
        shopRepository.deleteById(id);
    }

    @Override
    public List<Shop> getAll() {
        log.info("IN ShopServiceImplementation METHOD getAll");
        return shopRepository.findAll();
    }
}
