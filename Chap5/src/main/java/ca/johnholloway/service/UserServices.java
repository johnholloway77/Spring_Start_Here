package ca.johnholloway.service;

import ca.johnholloway.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private CommentRepository commentRepository;

    public CommentRepository getCommentRepository(){
        return commentRepository;
    }
}
