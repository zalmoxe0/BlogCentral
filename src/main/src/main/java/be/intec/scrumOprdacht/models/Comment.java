package be.intec.scrumOprdacht.models;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="blog_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @ManyToOne
    @JoinColumn(name = "user_comment_id")
    private User userOwnerComm;

    @ManyToOne
    @JoinColumn(name = "post_comment_id")
    private Blog commentPost;

    // one user can write many comments -> many to one
    // one comment can not have many user

    // one user can write many blogs -> many to one
    // one blog can not have many users

    // one blog can have many comments -> many to one
    // one comment can not have many blogs



}
