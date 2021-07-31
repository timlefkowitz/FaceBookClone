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



    /// insert

    public comment(String body, user commentOwner, user postOwner, user groupOwner) {
        this.body = body;
    }


    /// update

    public comment(long id, String body, user commentOwner, user postOwner, user groupOwner) {
        this.id = id;
        this.body = body;
    }


    //  copy

    public comment(comment copy)
    {
        id = copy.id;
        body = copy.body;
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

}
