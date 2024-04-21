package ca.holloway.service;

import ca.holloway.model.Comment;
import ca.holloway.proxy.CommentNotificationProxy;
import ca.holloway.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

//    @Autowired //field based injection. requires no arg constructor
//    private CommentRepository commentRepository; //notice how they're not final
//    @Autowired //field based injection. Requires no-arg constructor
//    private  CommentNotificationProxy commentNotificationProxy; //cant be final otherwise cant Dep. Inj.


//    //for args-based construction
//    @Autowired //really only needed for classes with more than one constructor. With one construct it's not needed
//    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy){
//        this.commentRepository = commentRepository;
//        this.commentNotificationProxy = commentNotificationProxy;
//    }

    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    public CommentService(
            CommentRepository commentRepository,
            @Qualifier(value = "SNAIL") CommentNotificationProxy commentNotificationProxy){
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }

}
