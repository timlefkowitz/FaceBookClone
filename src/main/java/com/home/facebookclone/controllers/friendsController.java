package com.home.facebookclone.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class friendsController {


    //    Wiring in FileStack
    @Value("${filestack.api.key}")
    private String fileStackApi;


    //daos



    // constructors
}
