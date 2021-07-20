package com.home.facebookclone.models;


import javax.persistence.*;
import java.util.List;

@Entity // << this is how hibernate knows to make tables out of the class
@Table(name="user")
public class  user {



    public user(){

    }


    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] the Blank function              [][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]

    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] Calling instances               [][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

// trying to get work done on the via/bus haha

    @Column(name = "firstname", length = 100)
    private String firstname;

    @Column(name = "middleName",  length = 40)
    private String middleName;

    @Column(name = "lastName",  length = 40)
    private String lastName;

    @Column(name = "username",  length = 100)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password",   length = 100)
    private String password;

    @Column(name = "profile", nullable = true)
    private String profile;

    @Column(name = "mobile", nullable = false, length = 36)
    private long mobile;

    @Column(name = "status", nullable = true, length = 40)
    private String status;

    @Column(name = "imgPath")
    private String imgPath;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "friendslist")
//    private friendslist friendslist;

    @Column(nullable = false)
    private boolean isAdmin;

    @Column(nullable = false)
    private String location;




//    @Column(name = "friendslist", nullable = true)
//    private List<friendslist> friendslist;

//    @Column(nullable = true)
//    private boolean is_admin;



    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerOfPost")
//    private List<post> postOwner;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerOfGroup")
//    private List<groups> groupOwner;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "GroupPostOwner")
//    private List<groupPost> groupPosts;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "RecieverOfMessage")
//    Private List<Messages> MSGreciver;



    // Insert Constructor

    public user(String firstName, String middleName, String lastName, String username, String email, String password, String intro, String profile, long mobile, String status, String imgPath, List friendslist, Boolean isAdmin, String location) {
        this.firstname = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.profile = profile;
        this.mobile = mobile;
        this.status = status;
        this.imgPath = imgPath;
        this.location = location;

    }


    // update Constructor

    public user(long id, String firstName, String middleName, String lastName, String username, String email, String password, String intro, String profile, long mobile, String status, String imgPath, Boolean isAdmin, String location, List friendslist) {
        this.id = id;
        this.firstname = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.profile = profile;
        this.mobile = mobile;
        this.status = status;
        this.imgPath = imgPath;
        this.location = location;

    }


    // Copy Constructor


    public user(user copy) {
        id = copy.id;
        firstname = copy.firstname;
        middleName = copy.middleName;
        lastName = copy.lastName;
        username = copy.username;
        email = copy.email;
        password = copy.password;
        profile = copy.profile;
        mobile = copy.mobile;
        status = copy.status;
        imgPath = copy.imgPath;
        isAdmin = copy.isAdmin;
        location = copy.location;

    }


    // GETTERS AND SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

//    public com.home.facebookclone.models.friendslist getFriendslist() {
//        return friendslist;
//    }
//
//    public void setFriendslist(com.home.facebookclone.models.friendslist friendslist) {
//        this.friendslist = friendslist;
//    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
