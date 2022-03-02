package be.intec.scrumOprdacht.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "admin_blog")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    private Integer id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "passcode", nullable = false)
    private String passCode;

}
