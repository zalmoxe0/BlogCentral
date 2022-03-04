package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    Optional<User> findByEmail(@Param("email") String email);
//
//    Optional<User> findByUsername(String userName);
//
//    @Query("Select u from User u WHERE u.userName = :userName")
//    public User getUserByUsername(@Param("userName") String userName);


    User findByEmail(String email);


}
