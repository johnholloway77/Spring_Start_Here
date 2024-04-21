package ca.holloway.proxy.impl;

import ca.holloway.model.Comment;
import ca.holloway.proxy.CommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SNAIL")
public class SnailMailNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending a physical letter for: " + comment.getText());
    }
}
