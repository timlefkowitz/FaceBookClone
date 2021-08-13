package com.home.facebookclone.models;


import javax.persistence.*;

@Entity
@Table(name="status")
public class status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "statusOwner")
    private user statusOwner;
}
