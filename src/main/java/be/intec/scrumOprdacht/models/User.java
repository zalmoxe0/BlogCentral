    package be.intec.scrumOprdacht.models;

    import lombok.*;
    import javax.persistence.*;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Table(name="user")
    public class User {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name = "user_id")
        private Integer id;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(name = "user_name", nullable = false, unique = true)
        private String userName;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "street")
        private String street;

        @Column(name = "house_no")
        private String houseNo;

        @Column(name = "city")
        private String city;

        @Column(name = "zip")
        private String zip;

        @Column(name = "pass_code", nullable = false)
        private String passCode;

    //    @Column(name = "retype_the_passcode", nullable = false)
    //    private String retypeThePasscode;

    //     @OneToMany
    //     @JoinColumn(name = "author")
    //     private List<Blog> blogs = new ArrayList<>();




    }




