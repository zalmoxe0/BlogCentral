package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    Optional<User> findByEmail(@Param("email") String email);
//
//    Optional<User> findByUsername(String userName);
//
//    @Query("Select u from User u WHERE u.userName = :userName")
//    public User getUserByUsername(@Param("userName") String userName);

}
