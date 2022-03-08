package be.intec.scrumOprdacht.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="posts")
public class Post {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "creation", nullable = false)
    private Timestamp creation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    @Column(name = "views")
    private Long views;

    @Column(name = "likes")
    private Long likes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Post post = (Post) o;
        return id != null && Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
