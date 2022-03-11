package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.Role;
import be.intec.scrumOprdacht.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByRole(@Param("role") String role){
        return roleRepository.findByRole(role);
    }
}
