package com.home.facebookclone.models;


import com.home.facebookclone.repos.friendslistrepo;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.List;

@Entity
@Table(name="friendslist")
public class friendslist {




    // table elements
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Column(name = "pendingFriend")           add pending friends in the future
//    private long id;


    @Column(name = "username")
    private String username;

    //insert

    public friendslist(String username) {
        this.username = username;
    }


    //update

    public friendslist(long id, String username) {
        this.id = id;
        this.username = username;
    }


    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
