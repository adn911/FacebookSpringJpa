package org.facebookjpa.persistance.entity;

import javax.persistence.*;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */

@Entity
@Table(name = "comments")
public class Comment extends Persistent {

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Comment() {
    }


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {

        String commentString = "ID :" + id + "\n" + "USER_ID :" + user.getId() + "\n" + "POST_ID :" + post.getId() + "\n" +
                "CONTENT :" + content + "\n" + "COMMENT_DATETIME :" + updated + "\n";

        return commentString;
    }
}
