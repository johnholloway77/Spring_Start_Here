package ca.holloway;

import ca.holloway.config.ProjectConfig;
import ca.holloway.model.Comment;
import ca.holloway.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Using a framework!\n");

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Josie the cat");
        comment.setText("Meow food! Food! Meow!");


        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}