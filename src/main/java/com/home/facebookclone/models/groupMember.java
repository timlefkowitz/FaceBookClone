package com.home.facebookclone.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="groupMember")
public class groupMember implements Serializable {

    public groupMember() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "group_id")
    private Long groupId;

//    @ManyToOne
//    @JoinColumn(name = "groupMember_id")
//    private groups groupMember;





    //insert

    public groupMember(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }


    //update


    public groupMember(long id, Long userId, Long groupId) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
    }



    // getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
