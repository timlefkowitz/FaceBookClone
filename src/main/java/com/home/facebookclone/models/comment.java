//package com.home.facebookclone.models;
//
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//@Table(name = "comments")
//public class comment {
//
//    public comment(){
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(length = 3096)
//    private String body;
//
//    @ManyToOne
//    @JoinColumn(name = "statusComments")
//    private comment statusComments;
//
//
//
//    /// insert
//
//    public comment(String body, comment statusComments) {
//        this.body = body;
//        this.statusComments = statusComments;
//    }
//
//
//    /// update
//
//
//    public comment(long id, String body, comment statusComments) {
//        this.id = id;
//        this.body = body;
//        this.statusComments = statusComments;
//    }
//
//    //  copy
//    public comment(comment copy)
//    {
//        id = copy.id;
//        body = copy.body;
//    }
//
//
//    /// Getters and setters
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public comment getStatusComments() {
//        return statusComments;
//    }
//
//    public void setStatusComments(comment statusComments) {
//        this.statusComments = statusComments;
//    }
//}
