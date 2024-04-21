package ca.holloway.proxy;

import ca.holloway.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);

}
