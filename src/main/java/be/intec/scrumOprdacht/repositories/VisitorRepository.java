package be.intec.scrumOprdacht.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import be.intec.scrumOprdacht.models.User;



public interface VisitorRepository extends JpaRepository<User,Integer> {

    public User findVisitorByNameAndPassWord(String userName, String passWord);

}
