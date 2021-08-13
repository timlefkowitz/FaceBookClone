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

    @Column(length = 3096)
    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusComments")
    @JsonBackReference
    private Collection<comment> statusComments;

    //insert

    public status(user statusOwner, String status, Collection<comment> statusComments) {
        this.statusOwner = statusOwner;
        this.status = status;
        this.statusComments = statusComments;
    }


    //update


    public status(long id, user statusOwner, String status, Collection<comment> statusComments) {
        this.id = id;
        this.statusOwner = statusOwner;
        this.status = status;
        this.statusComments = statusComments;
    }

    public status() {

    }


    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public user getStatusOwner() {
        return statusOwner;
    }

    public void setStatusOwner(user statusOwner) {
        this.statusOwner = statusOwner;
    }

    public Collection<comment> getStatusComments() {
        return statusComments;
    }

    public void setStatusComments(Collection<comment> statusComments) {
        this.statusComments = statusComments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
