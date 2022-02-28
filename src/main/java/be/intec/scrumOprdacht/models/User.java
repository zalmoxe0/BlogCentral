package be.intec.scrumOprdacht.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users_blog")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "street")
    private String street;

    @Column(name = "house_no")
    private String houseNo;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;

    @Column(name = "passcode", nullable = false)
    private String passCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userBlogOwner")
    private List<Blog> blogs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userOwnerComm")
    private List<Comment> comments;

}






