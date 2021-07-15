package com.home.facebookclone.controllers;


import com.home.facebookclone.models.groups;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.groupPost;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateControllers {

    private final UsersRepository usersDao;

    private final groupRepo groupDao;

    private final groupPost groupPostDao;


    public CreateControllers(UsersRepository usersDao, groupRepo groupDao, groupPost groupPostDao) {
        this.usersDao = usersDao;
        this.groupDao = groupDao;

        this.groupPostDao = groupPostDao;
    }


    // User Sign Up

    @GetMapping("/Signup")
    public String Signup()
    {
        return"Signup";
    }

    @PostMapping("/Signup")
    public String addANewUser(@RequestParam(name="username") String username,
                               @RequestParam(name="email") String email,
                              @RequestParam(name="password") String password,
                              @RequestParam(name="firstname") String firstname,
                              @RequestParam(name="middlename") String middlename,
                              @RequestParam(name="lastname") String lastname,
                              @RequestParam(name="mobilenumber") long mobilenumber,
                              @RequestParam(name="status") String status,
                              @RequestParam(name="profile") String profile

    ){

        user n = new user();
        n.setUserName(username);
        n.setEmail(email);
        n.setPasswordHash(password);
        n.setFirstName(firstname);
        n.setMiddleName(middlename);
        n.setLastName(lastname);
        n.setMobile(mobilenumber);
        n.setStatus(status);
        n.setProfile(profile);
        usersDao.save(n);
        return "redirect:/UsersHome";
    }

    // Create a Group

    @GetMapping("/groupcreation")
    public String createAgroup()
    {
        return"CreateAGroup";
    }


    @PostMapping("/groupcreation")
    public String addAnewGroup(@RequestParam(name="title") String title,
                               @RequestParam(name="Description") String description){

        groups n = new groups();
        n.setTitle(title);
        n.setContent(description);
        groupDao.save(n);
        return "redirect:/UsersHome";
    }


    // Create a Group Post

    @GetMapping("/PostToAGroup")
    public String postToAGroup()
    {
        return"GroupPostingForm";
    }

    @PostMapping("/PostToAGroup")
    public String addAnewGroupPost(@RequestParam(name="title") String title,
                                   @RequestParam(name="Description") String description){


//        groupPost n = new groupPost();
//        groupPostDao.save(n);
        return "redirect:/UsersHome";
    }


    // Create a Users Post

    @GetMapping("/post")
    public String usersPost()
    {
        return"UserPostingForm";
    }





}
