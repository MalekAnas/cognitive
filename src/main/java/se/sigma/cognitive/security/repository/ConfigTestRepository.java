package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sigma.cognitive.security.model.config.ConfigTest;

@Repository
public interface ConfigTestRepository extends JpaRepository<ConfigTest, Long> {
}
