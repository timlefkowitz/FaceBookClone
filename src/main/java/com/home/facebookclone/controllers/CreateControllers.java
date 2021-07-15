package com.home.facebookclone.controllers;


import com.home.facebookclone.models.groups;
import com.home.facebookclone.repos.groupPost;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateControllers {

    private final groupRepo groupDao;
    private final groupPost groupPostDao;


    public CreateControllers(groupRepo groupDao, groupPost groupPostDao) {
        this.groupDao = groupDao;
        this.groupPostDao = groupPostDao;
    }


    // User Sign Up

    @GetMapping("/Signup")
    public String Signup()
    {
        return"Signup";
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

        groupPost n = new groupPost();
        groupPostDao.save(n);
        return "redirect:/UsersHome";
    }


    // Create a Users Post

    @GetMapping("/post")
    public String usersPost()
    {
        return"UserPostingForm";
    }





}
