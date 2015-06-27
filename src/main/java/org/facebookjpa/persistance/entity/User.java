package org.facebookjpa.persistance.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */

@Entity
@Table(name = "users")
public class User extends Persistent {

    @NotEmpty
    @Size(min = 4, max = 16)
    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Size(min = 3, max = 99)
    @Column(name = "PASSWORD", nullable = false)
    private String password;


    @Column(name = "ACTIVE")
    private boolean active = true;

    @NotEmpty
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotEmpty
    @Column(name = "DOB", nullable = false)
    private String DOB;

    @Column(name = "PROFILE_PICTURE")
    private String profilePicture;

    //user activities

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Like> likes;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "friends",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "friendId")})
    private List<User> friends;

    @ManyToMany(mappedBy = "friends", fetch = FetchType.LAZY)
    private List<User> friendsWith;

    public static int numberOfLoggedInUsers = 0;

    public User() {
    }


    public User(String username, String email, String password, boolean active, String firstName, String lastName, String DOB, String profilePicture) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }


    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getFriendsWith() {
        return friendsWith;
    }

    public void setFriendsWith(List<User> friendsWith) {
        this.friendsWith = friendsWith;
    }

    public void update(User updatedUser) {
        this.username = updatedUser.getUsername();
        this.lastName = updatedUser.getLastName();
        this.firstName = updatedUser.getFirstName();
        this.DOB = updatedUser.getDOB();
        this.email = updatedUser.getEmail();
        this.password = updatedUser.getPassword();
        this.profilePicture = updatedUser.getProfilePicture() == null
                || updatedUser.getProfilePicture().isEmpty() ? profilePicture : updatedUser.getProfilePicture();
    }

    public String toString() {
        String userString = "ID :" + id + "\n" + "USERNAME :" + username + "\n" + "FIRSTNAME :" + firstName + "\n" +
                "LASTNAME :" + lastName + "\n" + "EMAIL :" + email + "\n" + "PASSWORD :" + password + "\n" +
                "DOB :" + DOB + "\n" + "STATUS :" + active + "\n";
        return userString;
    }

}
