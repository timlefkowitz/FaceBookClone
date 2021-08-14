package com.home.facebookclone.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="groupMember")
public class groupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="list_owner_id")
    @JsonManagedReference
    private groups ownerUser;

    @ManyToOne
    @JoinColumn(name="added_user_id")
    @JsonManagedReference
    private user added_user_id;


    public groupMember(long id, groups ownerUser, user added_user_id) {
        this.id = id;
        this.ownerUser = ownerUser;
        this.added_user_id = added_user_id;
    }

    public groupMember(groups ownerUser, user added_user_id) {
        this.ownerUser = ownerUser;
        this.added_user_id = added_user_id;
    }

    public groupMember() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public groups getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(groups ownerUser) {
        this.ownerUser = ownerUser;
    }

    public user getAdded_user_id() {
        return added_user_id;
    }

    public void setAdded_user_id(user added_user_id) {
        this.added_user_id = added_user_id;
    }
}
