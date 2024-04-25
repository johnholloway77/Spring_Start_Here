package ca.johnholloway;

import ca.johnholloway.config.ProjectConfig;
import ca.johnholloway.model.Comment;
import ca.johnholloway.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        System.out.println("Chapter Six: Aspects");

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Fantom t. Cat");

        //String value = service.publishComment(comment);

        //service.editComment(comment);
        service.deleteComment(comment);

        //logger.info(value);

    }
}