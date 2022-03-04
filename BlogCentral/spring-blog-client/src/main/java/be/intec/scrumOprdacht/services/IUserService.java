Alexandru

package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.entity.VerificationToken;
import be.intec.scrumOprdacht.entity.User;
import be.intec.scrumOprdacht.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {

//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PostRepository postRepository;
//
//    private static final String UserType = "Type of User";
//
//    public Optional<User> findForId(Integer id) {
//        return userRepository.findById(id);
//    }

//    public Optional<User> findByUsername(String userName) {
//        return userRepository.findByUsername(userName);
//    }
//
//    public Optional<User> findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//
//    public void save(User user) {
//        userRepository.save(user);
//    }

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}



