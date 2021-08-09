package com.home.facebookclone.controllers;


/*
        group controller
        tue Aug 3 2021

 */

import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.groups;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.groupPostRepo;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

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

    @PostMapping("/groups")
    public String groupsPage(@RequestParam(name = "addedUser") String addedUser,
                             @RequestParam(name = "currentGroup") String currentGroup
    )
    {


        user userInSession = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        user currentUser = userDao.getById(userInSession.getId());
        user addthisUser = userDao.getByUsername(addedUser);
        groups groupThatUserWillBeAddedTo = groupDao.getByTitle(currentGroup);


//        friendslist n = new friendslist();

//        userInSession.getContactListOwner();
        Collection<groups> currentgroups = currentUser.getGroupMember();
        currentUsersFriends.add(new friendslist(currentUser, addthisUser));
//        n.setOwner_user(userInSession);
//        n.setAdded_user_id(addthisUser);
        currentUser.setContactListOwner(currentUsersFriends);
        users.save(currentUser);



        Collection<friendslist> addFriend = userInSession.getContactListOwner();


//        user addthisUserID = users.getById(addID);
//
//        addFriend.setOwner_user(friendslistOwner);
//        addFriend.setAdded_user_id(addthisUserID);
//        friends.save(addFriend);


//        return"redirect:/friends";
        return "redirect:/groups";
    }

    @GetMapping("/groups")
    public String getFriends(Model view, @RequestParam(name = "currentGroup") String currentGroup)
    {

        user FRIENDSLISTOWNER = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<friendslist> friendslistGen = friends.getByOwnerUser(FRIENDSLISTOWNER);


        System.out.println(friendslistGen.size());
        view.addAttribute("friendslist", friendslistGen);





        return "groups";
    }
}
