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

    @OneToOne
    private user owner;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
//            JoinColumn = @JoinColumn(name = "user_id"),
            referencedColumnName = "id"
    )
    private user commentOwner;

    @ManyToOne
    @JoinColumn(name = "postOwner_id", referencedColumnName = "id")
    private user postOwner;


    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerOfPost")
//    private List<post> postOwner;
//


    // constructors
    // insert

    public usersPost(String title, String body, String imgPath) {

        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
    }


    // update

    public usersPost(long id, long createdBy, String title, String body, String imgPath) {
        this.id = id;

        this.title = title;
        this.body = body;
        this.imgPath = imgPath;
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

}
