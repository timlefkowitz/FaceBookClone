package com.home.facebookclone.controllers;

import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.friendslistrepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

//        Daos

    private UsersRepository users;
    private PasswordEncoder passwordEncoder;
    private friendslistrepo friendslistDao;


    public UserController(UsersRepository users, PasswordEncoder passwordEncoder, friendslistrepo friendslistDao) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.friendslistDao = friendslistDao;
    }


    //    Wiring in FileStack
    @Value("${filestack.api.key}")
    private String fileStackApi;


//        Sign Up


    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new user());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute user user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/home";
    }

//        Friends



    @GetMapping("/friends")
    public String friendspage(Model view)
    {

        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allposts", postsRepo.findAll());
        return"friends";
    }




}
