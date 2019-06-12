package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.sigma.cognitive.security.model.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleName);

    @Query(value = "select role.name from role where role.id = :roleId" , nativeQuery = true)
    String getRoleNameById(Long roleId);


    @Query(value = "select role_id from users_roles where user_id = :userId " , nativeQuery = true)
    List<Long> getRoleIdsByUserId( Long userId);



}
