package com.home.facebookclone.models;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 3096)
    private String body;

}
