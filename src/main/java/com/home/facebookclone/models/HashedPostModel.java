package com.home.facebookclone.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

@Entity
@Table(name="hashedPosts")
public class HashedPostModel {


    public HashedPostModel(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="hashedPostCollection")
    @JsonManagedReference
    private user hashedPostOwner;

    @Column
    private String hashedPostFinalString;





    // constructor

    public HashedPostModel(long id, user hashedPostOwner, String hashedPost) {
        this.id = id;
        this.hashedPostOwner = hashedPostOwner;
        this.hashedPostFinalString = hashedPost;
    }

    // update

    public HashedPostModel(user hashedPostOwner, String hashedPost) {
        this.hashedPostOwner = hashedPostOwner;
        this.hashedPostFinalString = hashedPost;
    }


    // getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public user getHashedPostOwner() {
        return hashedPostOwner;
    }

    public void setHashedPostOwner(user hashedPostOwner) {
        this.hashedPostOwner = hashedPostOwner;
    }

    public String getHashedPost() {
        return hashedPostFinalString;
    }

    public void setHashedPost(String hashedPost) {
        this.hashedPostFinalString = hashedPost;
    }
}
