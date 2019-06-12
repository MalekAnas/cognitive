package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.sigma.cognitive.security.model.Profile;

public interface ProfileRepository  extends JpaRepository<Profile, Long> {




}
