package ca.johnholloway.service;

import ca.johnholloway.annotation.ToLog;
import ca.johnholloway.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment){
        logger.info("Publishing comment: " + comment.getText() + " By: " + comment.getAuthor());
        //return "SUCCESS";
    }

    @ToLog
    public String deleteComment(Comment comment){
        logger.info("Deleting Comment: " + comment.getText());
        return "SUCCESS";
    }

    public void editComment(Comment comment){
        logger.info("Editing Comment: " + comment.getText());
    }
}
