package be.intec.scrumOprdacht.controllers.interfaces;

import be.intec.scrumOprdacht.models.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface UserController {

    String goToLoginPage(Model model, HttpSession httpSession);

    String Login(User userReceived, HttpSession httpSession);
}
