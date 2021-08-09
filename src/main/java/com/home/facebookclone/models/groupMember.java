package com.home.facebookclone.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="groupMember")
public class groupMember {

    public groupMember() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Root")
    private String Root;

    @ManyToOne
    @JoinColumn(name = "groupMember_id")
    private groups groupMember;


    @ManyToOne
    @JoinColumn(name = "groupOWner")
    public user groupOwner;


    //insert

    public groupMember(String root, groups groupMember) {
        Root = root;
        this.groupMember = groupMember;
    }


    //update

    public groupMember(long id, String root, groups groupMember) {
        this.id = id;
        Root = root;
        this.groupMember = groupMember;
    }


    // getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoot() {
        return Root;
    }

    public void setRoot(String root) {
        Root = root;
    }

    public groups getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(groups groupMember) {
        this.groupMember = groupMember;
    }
}
