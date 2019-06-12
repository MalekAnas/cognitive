package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.sigma.cognitive.security.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String userEmail);
    User getUserById(Long id);
    List<User> findAllByCreatedBy(String createdBy);
    void deleteById(Long id);





}
