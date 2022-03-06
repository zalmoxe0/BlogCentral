package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer> {

    @Query(
            value = "select p from Post p " +
                    " Order By p.comments.size desc",
            countQuery = "select count(p) from Post p "
    )
    Page<Post> findAllWithCommentsCountDesc(Pageable pageable);
}
