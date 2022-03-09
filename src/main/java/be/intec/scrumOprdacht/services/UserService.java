package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        System.out.println(user);
        userRepository.save(user);
    }

    public User getUserByPassWordAndUserName(String userName, String passCode){
        return userRepository.findUserByUserNameAndPassCode(userName,passCode);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUserName(username);
    }


}
