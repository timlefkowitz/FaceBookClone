package com.home.facebookclone.models;

import javax.persistence.*;
import java.sql.Timestamp;
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

    // THERE CAN BE MANY OWNERS THAT OWN THINGS???????

    @OneToOne
    private user groupOwner;

    @ManyToOne(cascade = CascadeType.ALL)
    private List<groups> igroups;

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

    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerOfGroup")
//    private List<groups> groupOwner;


    // Insert Constructor

    public groups(String createdBy, String title, String summary, String profile, String content, user owner) {
        this.CreatedBy = createdBy;
        this.title = title;
        this.summary = summary;
        this.profile = profile;
        this.content = content;
        this.owner = owner;
    }


    // Update Constructor

    public groups(long id, String createdBy, String title, String summary, String profile, String content, user owner) {
        this.id = id;
        this.CreatedBy = createdBy;
        this.title = title;
        this.summary = summary;
        this.profile = profile;
        this.content = content;
        this.owner = owner;
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

    public user getOwner() {
        return owner;
    }

    public void setOwner(user owner) {
        this.owner = owner;
    }
}
