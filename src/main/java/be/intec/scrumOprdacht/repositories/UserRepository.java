package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


}
