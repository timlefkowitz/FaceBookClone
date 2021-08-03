package com.home.facebookclone.controllers;


import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.friendslistrepo;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MyProfileController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;
    private final friendslistrepo friendslistDao;


    public MyProfileController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo, friendslistrepo friendslistDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
        this.friendslistDao = friendslistDao;
    }


    @RequestMapping(value="/myprofile")
    public String myprofile(@PathVariable Long id, Model view, String username, String status, Principal principal){
        view.addAttribute("myprofile", userDao.getById(id));
        view.addAttribute("mygroups", groupDao.getById(id));
        view.addAttribute("username", userDao.getByUsername(username));
        view.addAttribute("usersPost", postsRepo.getById(id));
        view.addAttribute("{id}+friends", userDao.getById(id));
        view.addAttribute("myfriends", friendslistDao.getById(id));

        String n = principal.getName();
        view.addAttribute("myprofile", userDao.findByUsername(n));




        return "myprofile";
    }


}
