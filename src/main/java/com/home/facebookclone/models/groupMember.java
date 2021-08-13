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
    @Column(name = "user_id")
    private Long userId;
//
//    @Id
//    @Column(name = "group_id")
//    private Long groupId;
//
//    public enum UserGroupRole {
//        MEMBER, MODERATOR
//    }
//
//    @Enumerated(EnumType.STRING)
//    private UserGroupRole role;



    //insert
//
//    public groupMember(Long userId, Long groupId) {
//        this.userId = userId;
//        this.groupId = groupId;
//    }
//
//
//    //update
//
//    public groupMember(Long userId, Long groupId, UserGroupRole role) {
//        this.userId = userId;
//        this.groupId = groupId;
//        this.role = role;
//    }
//
//
//    // getters and setters
//
//
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(Long groupId) {
//        this.groupId = groupId;
//    }
}
