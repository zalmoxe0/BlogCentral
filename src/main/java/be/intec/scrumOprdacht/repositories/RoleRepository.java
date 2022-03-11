package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(@Param("role") String role);
}
