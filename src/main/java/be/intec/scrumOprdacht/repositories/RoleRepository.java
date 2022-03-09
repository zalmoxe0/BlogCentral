package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Role;
import org.springframework.data.repository.query.Param;

public interface RoleRepository {
    Role findByRole(@Param("role") String role);
}
