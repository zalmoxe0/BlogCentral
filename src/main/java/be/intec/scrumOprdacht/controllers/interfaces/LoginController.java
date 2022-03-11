package be.intec.scrumOprdacht.controllers.interfaces;

import java.security.Principal;

public interface LoginController {

    String login(Principal principal);
}
