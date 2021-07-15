package com.home.facebookclone.models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity // << this is how hibernate knows to make tables out of the class
@Table(name="groupPost")
public class groupPost {

    public groupPost(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "groupId")
    private long groupId;

    @Column(name = "userId")
    private long userId;

    @Column(name = "message")
    private String message;



    //Insert

    public groupPost(long groupId, long userId, String message) {
        this.groupId = groupId;
        this.userId = userId;
        this.message = message;
    }


    //update

    public groupPost(long id, long groupId, long userId, String message) {
        this.id = id;
        this.groupId = groupId;
        this.userId = userId;
        this.message = message;
    }


    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
