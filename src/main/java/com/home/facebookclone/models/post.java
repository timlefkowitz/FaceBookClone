package com.home.facebookclone.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="userPost")
public class post {

    public post(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    //
    //
    //
    // I'm making things nullable and realized id's, or dates should not be nullable
    //
    //
    @Column (length = 100)
    private long postId;

    @Column (length = 100)
    private String owner;

    @Column(length = 100)
    private long key;

    @Column(length = 100)
    private String content;

    @Column(length = 100)
    private String title;

    @Column(length = 100)
    private String body;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
//    private List<post> post;



    //Insert Constructor

    public post(long postId, long key, String content, String title, String body, String owner) {
        this.postId = postId;
        this.key = key;
        this.content = content;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }


    //Update Constructor


    public post(long id, long postId, long key, String content, String title, String body, String owner) {
        this.id = id;
        this.postId = postId;
        this.key = key;
        this.content = content;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }


    // Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
