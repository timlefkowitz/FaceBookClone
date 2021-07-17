package com.home.facebookclone.controllers;


import com.home.facebookclone.repos.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {


    // Repo Daos

    private final UsersRepository userDao;

    public HomeController(UsersRepository userDao) {
        this.userDao = userDao;
    }


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


    // HOME PAGE

    @GetMapping("/UsersHome")
    public String usersHome()
    {
        return"UsersHome";
    }

    @GetMapping("/UsersHome/{id}")
    public String showById(@PathVariable Long id, Model view){
        view.addAttribute("ads", userDao.getById(id));
        return "UsersHome";
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
