package com.home.facebookclone.models;


import javax.persistence.*;

@Entity
@Table(name="usersPost")
public class usersPost {

    public usersPost(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "CreatedBy")
    private long CreatedBy;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "imgPath")
    private String imgPath;



    // constructors
    // insert

    public usersPost(long createdBy, String title, String body, String imgPath) {
        CreatedBy = createdBy;
        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
    }


    // update

    public usersPost(long id, long createdBy, String title, String body, String imgPath) {
        this.id = id;
        CreatedBy = createdBy;
        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
    }


    // Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(long createdBy) {
        CreatedBy = createdBy;
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
