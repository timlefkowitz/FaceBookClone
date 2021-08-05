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

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {

//        Daos

    private UsersRepository users;
    private PasswordEncoder passwordEncoder;
    private friendslistrepo friends;


    public UserController(UsersRepository users, PasswordEncoder passwordEncoder, friendslistrepo friends) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.friends = friends;
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






}
