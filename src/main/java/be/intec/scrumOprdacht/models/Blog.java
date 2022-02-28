package be.intec.scrumOprdacht.models;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="blog_posts")
public class Blog {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer id;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @ManyToOne
    @JoinColumn(name = "user_blog_id")
    private User userBlogOwner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="commentPost")
    private List<Comment> comments;
}
