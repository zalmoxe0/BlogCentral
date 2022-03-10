package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUserNameAndPassCode(String userName, String passCode);

    Optional<User> findByEmail(@Param("email") String email);
    Optional<User> findByUserName(@Param("username") String userName);
    User save(User user);
}
