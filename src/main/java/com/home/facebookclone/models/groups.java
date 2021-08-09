package com.home.facebookclone.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity // << this is how hibernate knows to make tables out of the class
@Table(name="groupTable")
public class groups {

    public groups(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "CreatedBy")
    private String CreatedBy;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "profile")
    private String profile;

    @Column( name = "content")
    private String content;

    @Column(name = "groupavatar")
    private String groupavatar;



    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupPost")
    @JsonBackReference
    private List<groupPost> groupPost;

    @ManyToOne
    @JoinColumn(name = "groupOwner_id")
    private groups groupOwner;

    @ManyToOne
    @JoinColumn(name = "groupComment")
    private groups groupComment;

    @ManyToOne
    @JoinColumn(name = "groupMember_id")
    private groups groupMember;


    // THERE CAN BE MANY OWNERS THAT OWN THINGS???????




    // Insert Constructor

    public groups(String createdBy, String title, String summary, String profile, String content, user owner, String groupavatar) {
        this.CreatedBy = createdBy;
        this.title = title;
        this.summary = summary;
        this.profile = profile;
        this.content = content;
//        this.groupOwner = owner;
    }


    // Update Constructor

    public groups(long id, String createdBy, String title, String summary, String profile, String content, user owner, String groupavatar) {
        this.id = id;
        this.CreatedBy = createdBy;
        this.title = title;
        this.summary = summary;
        this.profile = profile;
        this.content = content;
//        this.groupOwner = owner;
    }


    // Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGroupavatar() {
        return groupavatar;
    }

    public void setGroupavatar(String groupavatar) {
        this.groupavatar = groupavatar;
    }

    public List<com.home.facebookclone.models.groupPost> getGroupPost() {
        return groupPost;
    }

    public void setGroupPost(List<com.home.facebookclone.models.groupPost> groupPost) {
        this.groupPost = groupPost;
    }

    public groups getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(groups groupOwner) {
        this.groupOwner = groupOwner;
    }

    public groups getGroupComment() {
        return groupComment;
    }

    public void setGroupComment(groups groupComment) {
        this.groupComment = groupComment;
    }

    public groups getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(groups groupMember) {
        this.groupMember = groupMember;
    }
}
