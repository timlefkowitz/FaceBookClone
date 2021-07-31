package com.home.facebookclone.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usersPost")
public class usersPost {

    public usersPost(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "imgPath")
    private String imgPath;



    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //




    // constructors
    // insert


    public usersPost(String title, String body, String imgPath, user owner, user username) {
        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
    }




    // update



    public usersPost(long id, String title, String body, String imgPath, user owner, user username) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
//        this.owner = owner;
//        this.username = username;
    }

    // Getters and Setters




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }



}
