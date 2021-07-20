package com.home.facebookclone.models;


import javax.persistence.*;

@Entity
@Table(name = "userPostImgs")
public class userPostImgs {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "usersPost")
    private usersPost usersPost;

    public userPostImgs() {}

    // insert

    public userPostImgs(String path, String description, usersPost usersPost) {
        this.path = path;
        this.description = description;
        this.usersPost = usersPost;
    }


    // update

    public userPostImgs(long id, String path, String description, usersPost usersPost) {
        this.id = id;
        this.path = path;
        this.description = description;
        this.usersPost = usersPost;
    }


    // getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.home.facebookclone.models.usersPost getUsersPost() {
        return usersPost;
    }

    public void setUsersPost(com.home.facebookclone.models.usersPost usersPost) {
        this.usersPost = usersPost;
    }
}