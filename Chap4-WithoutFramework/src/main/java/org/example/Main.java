package org.example;

import org.example.model.Comment;
import org.example.proxy.impl.EmailCommentNotificationProxy;
import org.example.respository.impl.DBCommentRepository;
import org.example.service.CommentService;

public class Main {
    public static void main(String[] args) {


        var commentRespository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRespository, commentNotificationProxy);

        var comment = new Comment();
        comment.setAuthor("Pickles t. Cat");
        comment.setText("Meow meow meow");

        commentService.publishComment(comment);



    }
}