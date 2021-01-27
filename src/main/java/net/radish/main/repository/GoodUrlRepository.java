package net.radish.main.repository;

import net.radish.main.model.GoodUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodUrlRepository extends JpaRepository<GoodUrl, Long> {
}