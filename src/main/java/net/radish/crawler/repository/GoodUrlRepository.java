package net.radish.crawler.repository;

import net.radish.crawler.model.Good;
import net.radish.crawler.model.GoodUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodUrlRepository extends JpaRepository<GoodUrl, Long> {
}