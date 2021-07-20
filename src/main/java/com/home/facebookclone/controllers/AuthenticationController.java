package com.home.facebookclone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {


    @GetMapping("/")
    public String landingPage()
    {
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





}