    package be.intec.scrumOprdacht.models;

    import lombok.*;
    import javax.persistence.*;

    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Table(name="admin")
    public class Admin {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "admin_id", nullable = false)
        private Integer id;

        @Column(name = "user_name", nullable = false, unique = true)
        private String userName;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "pass_code", nullable = false)
        private String passCode;



    }
