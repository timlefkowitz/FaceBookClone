package com.home.facebookclone.controllers;


import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.friendslistrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class friendsController {



//  I'm not sure if i want filestack here or not


    //    Wiring in FileStack   ///
//    @Value("${filestack.api.key}")
//    private String fileStackApi;


    //     Daos

    private UsersRepository users;
    private PasswordEncoder passwordEncoder;
    private friendslistrepo friends;



    //      Constructors

    public friendsController(UsersRepository users, PasswordEncoder passwordEncoder, friendslistrepo friends) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.friends = friends;
    }


    //      GetMapping and Post Mapping


    @GetMapping("/friends")
    public String friendspage(Model view, HttpServletRequest request, @RequestParam(name="friendslistHidden") long addID)
    {

        friendslist addFriend = new friendslist();
        user addthisUserID = users.getOne(addID);
        user friendslistOwner = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        addFriend.setOwner_user(friendslistOwner);
        addFriend.setAdded_user_id(addthisUserID);
        friends.save(addFriend);

        view.addAttribute("allusers", users.findAll());
        view.addAttribute("friends", friends.findContactsByOwner_userId(addID));
        return"friends";
    }

}
