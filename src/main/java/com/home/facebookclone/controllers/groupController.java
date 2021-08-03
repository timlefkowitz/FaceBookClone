package com.home.facebookclone.controllers;


/*
        group controller
        tue Aug 3 2021

 */

import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.groupPostRepo;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class groupController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final groupPostRepo groupPostDao;
    private final UsersPostRepo postsDao;

    // Blank



    public groupController(UsersRepository userDao, groupRepo groupDao, groupPostRepo groupPostDao, UsersPostRepo postsDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.groupPostDao = groupPostDao;
        this.postsDao = postsDao;
    }

    @GetMapping("/groups")
    public String groupHome(Model view)
            //@RequestParam(name="groupName") String title,
    {
//        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allgroupPost", groupPostDao.findAll());
//        view.addAttribute("groupName", groupDao.findByGroupName(title));
        return"groups";
    }
}
