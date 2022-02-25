package be.intec.scrumOprdacht.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import be.intec.scrumOprdacht.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    User findUserByNameAndPassWord(String userName, String passCode);

}
