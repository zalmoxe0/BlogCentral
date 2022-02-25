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

//        @OneToMany
//        @JoinColumn(name = "author")
//        private List<Blog> blogs = new ArrayList<>();

        /**
         * @return the id
         */


    }

//        @ManyToOne
//        @JoinColumn(name = "sender")
//        private User sender;

    //    DROP TABLE IF EXISTS TBL_USERS;
    //        CREATE TABLE TBL_USERS (
    //        id INT AUTO_INCREMENT  PRIMARY KEY,
    //        first_name VARCHAR(250) NOT NULL,
    //        last_name VARCHAR(250) NOT NULL,
    //        user_name VARCHAR(250) NOT NULL UNIQUE,
    //        email VARCHAR(250) NOT NULL,
    //        street VARCHAR(250),
    //        house_number INT,
    //        city VARCHAR(250),
    //        zip INT,
    //        passcode VARCHAR(250) NOT NULL
    //        );
    //
    //        DROP TABLE IF EXISTS TBL_ADMIN;
    //        CREATE TABLE TBL_ADMIN (
    //        id INT AUTO_INCREMENT  PRIMARY KEY,
    //        user_name VARCHAR(250) NOT NULL UNIQUE,
    //        email VARCHAR(250) NOT NULL,
    //        passcode VARCHAR(250) NOT NULL
    //        );
    //
    //        DROP TABLE IF EXISTS TBL_BLOGS;
    //        CREATE TABLE TBL_BLOGS (
    //        id INT AUTO_INCREMENT  PRIMARY KEY,
    //        body TEXT NOT NULL,
    //        title VARCHAR(255) NOT NULL,
    //        creation_date TIMESTAMP NOT NULL,
    //        user_id INT NOT NULL
    //        );
    //        DROP TABLE IF EXISTS TBL_COMMENTS;
    //        CREATE TABLE TBL_COMMENTS (
    //        id INT AUTO_INCREMENT  PRIMARY KEY,
    //        body TEXT NOT NULL,
    //        title VARCHAR(255) NOT NULL,
    //        creation_date TIMESTAMP NOT NULL,
    //        user_id INT NOT NULL
    //        );



