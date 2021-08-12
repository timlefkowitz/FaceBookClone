package com.home.facebookclone.controllers;


/*
        group controller
        tue Aug 3 2021

 */

import com.home.facebookclone.models.*;
import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.groupPostRepo;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class GroupController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final groupPostRepo groupPostDao;
    private final UsersPostRepo postsDao;



    //    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;






    // Blank
    public GroupController(UsersRepository userDao, groupRepo groupDao, groupPostRepo groupPostDao, UsersPostRepo postsDao){
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.groupPostDao = groupPostDao;

        this.postsDao = postsDao;
    }



    @PostMapping("/ADDgroups")
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
    public String groupsHomeView(Model view)
    {
////        1. addAttributes
//        view.addAttribute("allgroups", groupslistGenerator);
        view.addAttribute("allgroups", groupDao.findAll());

//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}
//        00.1 experiments and history

//        System Prints
//        System.out.println(groupMember);
        return "groups";
    }

    @GetMapping("groups/{title}")
    public String showGroupByTitle(@PathVariable String title,
                                 Model view
    ){
//            Current user and their username
        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usernameOfCurrentUser = currentUser.username;


//            Current Group
        groups currentGroup = groupDao.getByTitle(title);


//        0.001 add Attributes
        view.addAttribute("group", groupDao.getByTitle(title));


        return "groupHome";
    }



    // Create a Group Post

    @GetMapping("/PostToAGroup/{title}")
    public String postToAGroup(@PathVariable String title, Model model)
    {
        model.addAttribute("fileStackApi",fileStackApi);
        model.addAttribute("groupId", groupDao.findAll());  // When I come back to this we can link all groupsThatBelongToOwner
        model.addAttribute("group", groupDao.getByTitle(title));
        model.addAttribute("allgroups", groupDao.findAll());
        return"GroupPostingForm";
    }

    @PostMapping("/PostToAGroup/{title}")
    public String addAnewGroupPost(@RequestParam(name="GroupPosttitle") String title,
                                   @RequestParam(name="GroupPostsummary") String summary,
                                   @RequestParam(name="GroupPostcreatedBy") String createdBy,
                                   @RequestParam(name="GroupPostcontent") String content,
                                   @RequestParam(name="GroupPostIMGPath") String GroupPostIMGPath

    ){

        //            Current user and their username
        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usernameOfCurrentUser = currentUser.username;
//        Change from new group to current group
        groupPost n = new groupPost();
//        set the posts Requested Parameters
        n.setTitle(title);
        n.setBody(summary);
        n.setImgPath(GroupPostIMGPath);
//        save the post
        groupPostDao.save(n);
        return "redirect:/home";


        //        groupPost n = new groupPost();
//        groupPostDao.save(n);
    }



}
