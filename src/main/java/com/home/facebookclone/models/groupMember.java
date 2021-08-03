package com.home.facebookclone.models;


import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Controller
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


    //insert

    public groupMember(String root, groups groupMember) {
        Root = root;
        this.groupMember = groupMember;
    }


    //update



    // getters and setters



}
