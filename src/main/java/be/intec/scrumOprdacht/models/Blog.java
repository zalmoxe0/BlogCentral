    package be.intec.scrumOprdacht.models;

    import lombok.*;
    import javax.persistence.*;
    import java.sql.Timestamp;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Table(name="blog")
    public class Blog {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;

        @Column(name = "body", nullable = false)
        private String body;

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "user_id",nullable = false)
        private Integer Id;

        @Column(name = "creation_date", nullable = false)
        private Timestamp creationDate;

        @ManyToOne
        private User author;

//        @OneToMany
//        @JoinColumn(name="comments")
//        private List<Comment> comments = new ArrayList<>();

    }

