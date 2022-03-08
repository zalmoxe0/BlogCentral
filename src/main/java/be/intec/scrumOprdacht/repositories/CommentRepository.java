package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Integer>{
}
