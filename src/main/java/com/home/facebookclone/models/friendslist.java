package com.home.facebookclone.models;


import com.home.facebookclone.repos.friendslistrepo;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.List;

@Entity
@Table(name="friendslist")
public class friendslist {

    public friendslist() {

    }

//    // table elements
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
//
////    @Column(name = "pendingFriend")           add pending friends in the future
////    private long id;
//
//
//    @Column(name = "username")
//    private String username;
//
//    @OneToOne
//    private user owner;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "friendslist")
//    @JoinColumn(name="friendslist")
//    private friendslist friendslist;
//
//
//
//
//
//    //insert
//
//    public friendslist(String username, user owner) {
//        this.username = username;
//        this.owner = owner;
//
//    }
//
//
//    //update
//
//    public friendslist(long id, String username, user owner) {
//        this.id = id;
//        this.username = username;
//        this.owner = owner;
//
//    }
//
//
//
//
//    //getters and setters
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public user getOwner() {
//        return owner;
//    }
//
//    public void setOwner(user owner) {
//        this.owner = owner;
//    }
//
//    public com.home.facebookclone.models.friendslist getFriendslist() {
//        return friendslist;
//    }
//
//    public void setFriendslist(com.home.facebookclone.models.friendslist friendslist) {
//        this.friendslist = friendslist;
//    }
}
