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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @ManyToOne
    @JoinColumn(name="list_owner_id")
    @JsonManagedReference
    private user owner_user;

    @ManyToOne
    @JoinColumn(name="added_user_id")
    @JsonManagedReference
    private user added_user_id;


    // insert

    public friendslist(user owner_user, user added_user_id) {
        this.owner_user = owner_user;
        this.added_user_id = added_user_id;
    }


    // update

    public friendslist(long id, user owner_user, user added_user_id) {
        this.id = id;
        this.owner_user = owner_user;
        this.added_user_id = added_user_id;
    }


    // copy

    // getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public user getOwner_user() {
        return owner_user;
    }

    public void setOwner_user(user owner_user) {
        this.owner_user = owner_user;
    }

    public user getAdded_user_id() {
        return added_user_id;
    }

    public void setAdded_user_id(user added_user_id) {
        this.added_user_id = added_user_id;
    }
}
