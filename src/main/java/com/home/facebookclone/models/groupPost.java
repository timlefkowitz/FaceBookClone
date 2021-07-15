package com.home.facebookclone.models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity // << this is how hibernate knows to make tables out of the class
@Table(name="groupPost")
public class groupPost {

    public groupPost(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private long title;

    @Column(name = "ownerOfPost")
    private long ownerOfPost;

    @Column(name = "body")
    private String body;



    //Insert

    public groupPost(long title, long ownerOfPost, String body) {
        this.title = title;
        this.ownerOfPost = ownerOfPost;
        this.body = body;
    }


    //update

    public groupPost(long id, long title, long ownerOfPost, String body) {
        this.id = id;
        this.title = title;
        this.ownerOfPost = ownerOfPost;
        this.body = body;
    }


    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTitle() {
        return title;
    }

    public void setTitle(long title) {
        this.title = title;
    }

    public long getOwnerOfPost() {
        return ownerOfPost;
    }

    public void setOwnerOfPost(long ownerOfPost) {
        this.ownerOfPost = ownerOfPost;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
