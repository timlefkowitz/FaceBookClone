package com.home.facebookclone.models;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class comment {

    public comment(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 3096)
    private String body;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private user commentOwner;

    @ManyToOne
    @JoinColumn(name = "postOwner_id", referencedColumnName = "id")
    private user postOwner;

    @ManyToOne
    @JoinColumn(name = "groupOwner_id", referencedColumnName = "id")
    private user groupOwner;





    /// insert

    public comment(String body, user commentOwner, user postOwner, user groupOwner) {
        this.body = body;
        this.commentOwner = commentOwner;
        this.postOwner = postOwner;
        this.groupOwner = groupOwner;
    }


    /// update

    public comment(long id, String body, user commentOwner, user postOwner, user groupOwner) {
        this.id = id;
        this.body = body;
        this.commentOwner = commentOwner;
        this.postOwner = postOwner;
        this.groupOwner = groupOwner;
    }


    //  copy

    public comment(comment copy)
    {
        id = copy.id;
        body = copy.body;
        groupOwner = copy.groupOwner;
        postOwner = copy.postOwner;
    }


    /// Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public user getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(user commentOwner) {
        this.commentOwner = commentOwner;
    }

    public user getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(user postOwner) {
        this.postOwner = postOwner;
    }

    public user getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(user groupOwner) {
        this.groupOwner = groupOwner;
    }
}
