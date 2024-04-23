package ca.johnholloway.repository;

import ca.johnholloway.model.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentRepository {


    public void printComment(Comment comment){
        System.out.println("Comment title: " + comment.getTitle() + "  Comment text: " + comment.getText());
    }
}
