// Alexandru

package be.intec.scrumOprdacht.models;

import lombok.Data;

@Data
public class PasswordModel {

    private String email;
    private String oldPassword;
    private String newPassword;
}
