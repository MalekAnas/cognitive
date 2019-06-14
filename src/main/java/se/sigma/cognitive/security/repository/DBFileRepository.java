package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sigma.cognitive.security.model.FileModel;


@Repository
public interface DBFileRepository extends JpaRepository<FileModel, Long> {



}
