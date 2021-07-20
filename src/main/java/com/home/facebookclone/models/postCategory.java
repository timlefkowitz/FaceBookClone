package com.home.facebookclone.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="postCategory")
public class postCategory {
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @ManyToMany(mappedBy = "categories")
//    private List<postCategory> postCategory;
//
//    // insert
//    public postCategory(String name, List<postCategory> postCategory) {
//        this.name = name;
//        this.postCategory = postCategory;
//    }
//
//    // update
//
//
//    public postCategory(long id, String name, List<postCategory> postCategory) {
//        this.id = id;
//        this.name = name;
//        this.postCategory = postCategory;
//    }
//
//    public postCategory() {
//
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<postCategory> getPost() {
//        return postCategory;
//    }
//
//    public void setPost(List<postCategory> postCategory) {
//        this.postCategory = postCategory;
//    }
}
