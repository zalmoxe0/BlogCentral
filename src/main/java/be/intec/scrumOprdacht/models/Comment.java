    package be.intec.scrumOprdacht.models;

    import lombok.*;
    import javax.persistence.*;
    import java.sql.Timestamp;

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Table(name="comment")

    public class Comment {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;

        @Column(name = "body", nullable = false)
        private String body;

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "user_name", nullable = false, unique = true)
        private String userName;

        @Column(name = "creation_date", nullable = false)
        private Timestamp creationDate;

        @Column(name = "user_id",nullable = false)
        private Integer Id;




    }
