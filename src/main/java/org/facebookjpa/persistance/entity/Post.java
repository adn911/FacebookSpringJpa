package org.facebookjpa.persistance.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */

@Entity
@Table(name = "posts")
public class Post extends Persistent {

    @Column(name = "POST_TYPE", nullable = false)
    private int type;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Like> likes;

    public Post() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String toString() {

        String postString = "ID :" + id + "\n" + "USER_ID :" + user.getId() + "\n" + "POST_TYPE :" + type + "\n" +
                "CONTENT :" + content + "\n" + "POST_DATETIME :" + updated + "\n";

        return postString;
    }
}
