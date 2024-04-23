package ca.johnholloway.processor;

import ca.johnholloway.model.Comment;
import ca.johnholloway.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//By setting bean definition to prototype we avoid the problems with mutability when CommentService runs the function letsRock()
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

    //This class is to contain mutable information, such as comments and change their values.
    private Comment comment;

    @Autowired
    private CommentRepository commentRepository;

    public void setComment(Comment comment){
        this.comment = comment;
    }

    public Comment getComment(){
        return this.comment;
    }

    //these example methods are to change the values of the Comment
    public void setTitle(String title){
        this.comment.setTitle(title);
    }

    public void setText(String text){
        this.comment.setText(text);
    }

    public void save(){
        commentRepository.printComment(comment);
    }

}
