package ca.holloway.repository;

import ca.holloway.model.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentRepository {
    void storeComment(Comment comment);
}
