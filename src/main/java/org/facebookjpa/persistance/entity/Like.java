package org.facebookjpa.persistance.entity;

import javax.persistence.*;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */

@Entity(name = "PostLike")
@Table(name = "likes")
public class Like extends Persistent {

    @Column(name = "ACTIVE")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Like() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String toString() {

        String likeString = "LIKE_ID :" + id + "\n" + "USER_ID :" + user.getId() + "\n" + "POST_ID :" + post.getId() + "\n" +
                "DATETIME :" + updated + "\n" + "STATUS: " + active + "\n";

        return likeString;
    }
}
