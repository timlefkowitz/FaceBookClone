package com.home.facebookclone.models;


import com.home.facebookclone.repos.friendslistrepo;

import javax.persistence.*;

@Entity
@Table(name="friendslist")
public class friendslist {


    //importing repo
//    private final friendslistrepo friendslistDao;
//
//
//    public friendslist(friendslistrepo friendslistDao) {
//        this.friendslistDao = friendslistDao;
//    }


    // table elements
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Column(name = "pendingFriend")           add pending friends in the future
//    private long id;








}
