package be.intec.scrumOprdacht.models;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="blogs")
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

    @Column(name = "views")
    private Long views;

    @Column(name = "likes")
    private Long likes;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
