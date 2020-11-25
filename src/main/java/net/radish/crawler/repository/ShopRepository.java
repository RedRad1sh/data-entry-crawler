package net.radish.crawler.repository;

import net.radish.crawler.model.Good;
import net.radish.crawler.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}