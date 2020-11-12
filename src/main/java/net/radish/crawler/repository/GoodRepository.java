package net.radish.crawler.repository;

import net.radish.crawler.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Long> {

}
