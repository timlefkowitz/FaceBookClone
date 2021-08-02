package com.home.facebookclone.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @ManyToOne
    @JoinColumn(name="list_owner_id")
    @JsonManagedReference
    private user owner_user;


}
