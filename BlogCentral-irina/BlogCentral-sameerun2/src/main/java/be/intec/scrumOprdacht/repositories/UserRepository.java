package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
