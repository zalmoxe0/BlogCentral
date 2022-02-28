package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
