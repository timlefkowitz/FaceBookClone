/*
    FACEBOOK CLONE / PHOTONS / HELP TANK
    A Spring MVC FRAME FOR A SOCIAL MEDIA PLATFORM
    By Timothy Craig Lefkowitz and the help of Codeup!
    Aug 9th 2021
    Special Thanks to
         Douglas Hirsh
         Kenneth Howell
         Samuel Moore
         and everyone at Codeup


         Authentication Controller


 */

package com.home.facebookclone.controllers;

import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {


    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;



    //    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;



    @GetMapping("/")
    public String landingPage(Model view)
    {

        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allpost", postsRepo.findAll());
        return"index";
    }

    @GetMapping("/index")
    public String login()
    {
        return"index";
    }



    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }


    public AuthenticationController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
    }



//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "users/login";
//    }


//    @GetMapping("/admin")
//    public String adminHome(Model view)
//    {
//        view.addAttribute("allusers", userDao.findAll());
//        view.addAttribute("allgroups", groupDao.findAll());
//        return"admin/AdminsHome";
//    }








}