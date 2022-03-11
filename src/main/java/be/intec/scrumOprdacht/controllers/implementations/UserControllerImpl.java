package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.UserController;
import be.intec.scrumOprdacht.repositories.RoleRepository;
import be.intec.scrumOprdacht.repositories.UserRepository;
import be.intec.scrumOprdacht.services.RoleService;
import be.intec.scrumOprdacht.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final RoleService roleService;

    private static final String USER_ROLE = "ROLE_USER";

    @Autowired
    public UserControllerImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }

//    @Override
//    @GetMapping("login")
//    public String goToLoginPage(Model model, HttpSession httpSession) {
//
//        if (httpSession.getAttribute("loggedInUser") == null) {
//            model.addAttribute("user", new User("", ""));
//
//            return "login";
//
//        } else {
//
//            return "redirect:home";
//
//        }
//
//    }


//    @Override
//    @PostMapping("login")
//    public String Login(@ModelAttribute("user") User userReceived, HttpSession httpSession) {
//
//        System.out.println(userReceived.getUserName());
//        System.out.println(userReceived.getPassCode());
//
//        User foundUser = userService.getUserByPassWordAndUserName(userReceived.getUserName(), userReceived.getPassCode());
//
//        if(foundUser == null) {
//
//            System.out.println("no valid credentials");
//            return "redirect:login";
//
//        } else {
//
//            httpSession.setAttribute("loggedInUser", userReceived.getUserName());
//            return "redirect:home";
//
//        }
//
//    }
//
//
//    @PostMapping("logout")
//    public String logout(HttpSession httpSession, Model model) {
//
//        if (httpSession.getAttribute("loggedInUser") != null) {
//
//            model.addAttribute("user", new User("", ""));
//            return "home";
//
//        } else {
//
//            httpSession.setAttribute("loggedInUser", null);
//            return "redirect:login";
//
//        }
//
//    }

}
