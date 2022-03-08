package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
