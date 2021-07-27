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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private user commentOwner;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private user postOwner;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private user groupOwner;



}
