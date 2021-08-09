package com.home.facebookclone.controllers;


/*
        group controller
        tue Aug 3 2021

 */

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.groupMember;
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

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Controller
public class GroupController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final groupPostRepo groupPostDao;
    private final UsersPostRepo postsDao;




    // Blank



    public GroupController(UsersRepository userDao, groupRepo groupDao, groupPostRepo groupPostDao, UsersPostRepo postsDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.groupPostDao = groupPostDao;
        this.postsDao = postsDao;
    }

    @PostMapping("/groups")
    public String groupsAndgroupMembers(@RequestParam(name = "addedUser") String addedUser,
                             @RequestParam(name = "currentGroup") String currentGroup
    )
    {

//        1. generate the user
        user userInSession = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//            -- Define currentUser and get by their username ((username)) < Check It out get by username!!
        user currentUser = userDao.getByUsername(addedUser);


//        2. generate the list of group members
        List<groupMember> currentgroups = currentUser.getGroupMember();


//        3. generate what the current Groups Name is
        groups currentGroupsName = groupDao.getByTitle(currentGroup);


//        4. Create a new object of group member <<<< this needs to be moved where groups are created |||||
        currentgroups.add(new groupMember(userInSession));

//        5.  add new user to group
        currentUser.setGroupMember((List<groupMember>) currentGroupsName);
        groupDao.save(currentGroupsName);





//        APPLICATION WRAP UP / ORGINIZE TEMPLATE // BY TIMOTHY LEFKOWITZ , SAMUEL M, KENNETH HOWELL, DOUGLAS HIRSH THANK YOU

//        1. generate the user
//        2. generate the list of group members
//        3. generate what the current Groups Name is



//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}
//        00.1 experiments and history
//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}


//        user currentUser = userDao.getById(userInSession.getId());

//        friendslist n = new friendslist();

//        userInSession.getContactListOwner();
//        n.setOwner_user(userInSession);
//        n.setAdded_user_id(addthisUser);

//        Collection<friendslist> addFriend = userInSession.getContactListOwner();
//        user addthisUserID = users.getById(addID);
//
//        addFriend.setOwner_user(friendslistOwner);
//        addFriend.setAdded_user_id(addthisUserID);
//        friends.save(addFriend);


//        return"redirect:/friends";
        return "redirect:/groups";
    }

    @GetMapping("/groups")
    public String groupsHomeView(Model view, @RequestParam(name = "currentGroups") String currentGroup)
    {
//        1. who is the current user??
        user currentUSER = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        2. generate the current users groups

//        2.1 get currentUsers username for groupOwnership
        String currentUsersUsername = currentUSER.username;
        Collection<groups> groupslistGenerator = groupDao.getByGroupMember(currentUsersUsername);
//        3. Ok, I've already generated the current list. I need to come back to this. lets keep originzing'
        List<groupMember> groupMember = currentUSER.getGroupMember();
//        4. addAttributes
        view.addAttribute("friendslist", groupslistGenerator);



//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}
//        00.1 experiments and history


//        System Prints
        System.out.println(groupMember);

//        I believe from here I just need an addAttribute
//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}

//        view.addAttribute("friendslist", friendslistGen);

//        Collection<friendslist> friendslistGen = groups.getByGroupOwner(groupOwner);















        return "groups";
    }
}
