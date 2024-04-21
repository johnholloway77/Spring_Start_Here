package org.example.respository.impl;

import org.example.model.Comment;
import org.example.respository.CommentRepository;

public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment:" + comment.getText());
    }
}
