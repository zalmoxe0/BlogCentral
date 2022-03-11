package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.repositories.RoleRepository;
import be.intec.scrumOprdacht.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private static final String USER_ROLE = "ROLE_Author";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void createUser(User user){
        System.out.println(user);
        userRepository.save(user);
    }

    public User getUserByPassWordAndUserName(String userName, String passCode){
        return userRepository.findUserByUserNameAndPassCode(userName,passCode);
    }

    public Optional<User> getByUserName(String username){
        return userRepository.findByUserName(username);
    }
    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User createSave(User user) {
        // Encode plaintext password
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setActive(1);
        // Set Role to ROLE_USER
        user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
        return userRepository.save(user);
    }



}
