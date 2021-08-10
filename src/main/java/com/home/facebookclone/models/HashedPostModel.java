package com.home.facebookclone.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.home.facebookclone.repos.UsersRepository;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="hashedPosts")
public class HashedPostModel {

    @Controller
    public class userDaoImportExperiment{
        private final UsersRepository usersDao;

        public userDaoImportExperiment(UsersRepository usersDao) {
            this.usersDao = usersDao;

        }

        public UsersRepository getUsersDao() {
            return usersDao;
        }
    }



    public HashedPostModel(UsersRepository usersDao){

    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="hashedPostCollection")
    @JsonManagedReference
    private user hashedPostOwner;

    @Column
    private String hashedPostFinalString;


    String postOWnerUsername = userDao.username(username);


    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = hashedPostOwner + "")
    @JsonManagedReference
    private String hashPostTitle;





    // constructor

    public HashedPostModel(long id, user hashedPostOwner, String hashedPost) {
        this.id = id;
        this.hashedPostOwner = hashedPostOwner;
        this.hashedPostFinalString = hashedPost;
    }

    // update

    public HashedPostModel(user hashedPostOwner, String hashedPost) {
        this.hashedPostOwner = hashedPostOwner;
        this.hashedPostFinalString = hashedPost;
    }


    // getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public user getHashedPostOwner() {
        return hashedPostOwner;
    }

    public void setHashedPostOwner(user hashedPostOwner) {
        this.hashedPostOwner = hashedPostOwner;
    }

    public String getHashedPost() {
        return hashedPostFinalString;
    }

    public void setHashedPost(String hashedPost) {
        this.hashedPostFinalString = hashedPost;
    }
}
