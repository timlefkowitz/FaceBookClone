package com.home.facebookclone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="groupMemberModel")
public class groupMemberModel implements Serializable {

    public groupMemberModel(){

    }

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "group_id")
    private Long groupId;

    // constructors

    public groupMemberModel(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }


    // getters and setters

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
