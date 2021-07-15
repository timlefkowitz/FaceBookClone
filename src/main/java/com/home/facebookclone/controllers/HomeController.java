package com.home.facebookclone.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String landingPage()
    {
        return"index";
    }

    @GetMapping("/Admin")
    public String adminHome()
    {
        return"admin/AdminsHome";
    }

    @GetMapping("/UsersHome")
    public String usersHome()
    {
        return"UsersHome";
    }


    @GetMapping("/UsersProfile")
    public String usersProfile()
    {
        return"UsersProfile";
    }

    // Currently Signed in profile
    @GetMapping("/currentProfile")
    public String currentUsersProfile()
    {
        return"CurrentUsersProfileAndEditProfile";
    }







}
