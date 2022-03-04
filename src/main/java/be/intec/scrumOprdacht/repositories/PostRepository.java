package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer> {
}
