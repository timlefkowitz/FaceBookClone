package com.home.facebookclone.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusComments")
    @JsonBackReference
    private Collection<comment> statusComments;
}
