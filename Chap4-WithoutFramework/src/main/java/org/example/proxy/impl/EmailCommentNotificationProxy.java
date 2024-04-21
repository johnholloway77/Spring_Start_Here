package org.example.proxy.impl;

import org.example.model.Comment;
import org.example.proxy.CommentNotificationProxy;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: " + comment.getText());
    }
}
