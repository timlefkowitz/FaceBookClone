package com.home.facebookclone.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usersPost")
public class usersPost {

    public usersPost(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "imgPath")
    private String imgPath;

    @Column(name = "imgPath1")
    private String imgPath1;

    @Column(name = "imgPath2")
    private String imgPath2;

    @Column(name = "imgPath3")
    private String imgPath3;

    @OneToOne
    private user owner;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersPost")
//    private List<userPostImgs> images;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
////            name="post_categories",
//            joinColumns={@JoinColumn(name="userPostID")}
////            inverseJoinColumns={@JoinColumn(name="category_id")}
//    )
//    private List<postCategory> postCategories;


    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerOfPost")
//    private List<post> postOwner;
//


    // constructors
    // insert

    public usersPost(String title, String body, String imgPath,  String imgPath1, String imgPath2, String imgPath3) {

        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
        this.imgPath1 = imgPath1;
        this.imgPath2= imgPath2;
        this.imgPath3 = imgPath3;
    }


    // update

    public usersPost(long id, long createdBy, String title, String body, String imgPath, String imgPath1, String imgPath2, String imgPath3) {
        this.id = id;

        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
        this.imgPath1 = imgPath1;
        this.imgPath2= imgPath2;
        this.imgPath3 = imgPath3;

    }


    // Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public user getOwner() {
        return owner;
    }

    public void setOwner(user owner) {
        this.owner = owner;
    }
//
//    public List<userPostImgs> getImages() {
//        return images;
//    }
//
//    public void setImages(List<userPostImgs> images) {
//        this.images = images;
//    }
//
//    public List<postCategory> getPostCategories() {
//        return postCategories;
//    }
//
//    public void setPostCategories(List<postCategory> postCategories) {
//        this.postCategories = postCategories;
//    }


    public String getImgPath1() {
        return imgPath1;
    }

    public void setImgPath1(String imgPath1) {
        this.imgPath1 = imgPath1;
    }

    public String getImgPath2() {
        return imgPath2;
    }

    public void setImgPath2(String imgPath2) {
        this.imgPath2 = imgPath2;
    }

    public String getImgPath3() {
        return imgPath3;
    }

    public void setImgPath3(String imgPath3) {
        this.imgPath3 = imgPath3;
    }
}
