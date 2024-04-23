package ca.johnholloway;

import ca.johnholloway.config.ProjectConfig;
import ca.johnholloway.service.CommentService;
import ca.johnholloway.service.UserServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing singletons and prototypes!\n");

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //CommentService commentService = new CommentService(context);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.letsRock();

//        var cs1 = context.getBean("commentService", CommentService.class);
//        var cs2 = context.getBean("commentService", CommentService.class);
//        System.out.println(s1 == s2);

//        var s1 = context.getBean(CommentService.class);
//        var s2 = context.getBean(UserServices.class);
//
//        System.out.println(s1.getCommentRepository() == s2.getCommentRepository());
    }
}