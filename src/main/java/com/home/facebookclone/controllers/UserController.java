package com.home.facebookclone.controllers;

import com.home.facebookclone.models.user;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private user users;
//    private PasswordEncoder passwordEncoder;

//    public UserController(user users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new user());
        return "users/sign-up";
    }

//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute user user){
//        String hash = passwordEncoder.encode(user.getPasswordHash());
//        user.setPasswordHash(hash);
//        user.save(user);
//        return "redirect:/login";
//    }
}
