package com.home.facebookclone.models;


import com.home.facebookclone.repos.friendslistrepo;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="friendslist")
public class friendslist {

    public friendslist() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

}
