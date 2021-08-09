package com.home.facebookclone.controllers;


import com.home.facebookclone.models.*;
import com.home.facebookclone.repos.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateControllers {

    // instances

    private final UsersRepository usersDao;
    private final UsersPostRepo usersPost;
    private final groupRepo groupDao;
    private final groupPostRepo groupPostDao;
    private final PasswordEncoder passwordEncoder;
    private final friendslistrepo friendslistrepoDao;


    // constructors


    public CreateControllers(UsersRepository usersDao, UsersPostRepo usersPost, groupRepo groupDao, groupPostRepo groupPostDao, PasswordEncoder passwordEncoder, friendslistrepo friendslistrepoDao) {

        this.usersDao = usersDao;
        this.usersPost = usersPost;
        this.groupDao = groupDao;


//        this.groupPostDao = groupPostDao;
        this.groupPostDao = groupPostDao;
//        this.passwordEncoder = passwordEncoder;
        this.passwordEncoder = passwordEncoder;
//        this.friendsDao = friendsDao;
        this.friendslistrepoDao = friendslistrepoDao;
    }




//    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;




    // User Sign Up

    @GetMapping("users/sign-up")
    public String Signup(Model model)
    {
        model.addAttribute("user", new user());
        model.addAttribute("fileStackApi", fileStackApi);
        return"users/sign-up";
    }

    @PostMapping("users/sign-up")
    public String addANewUser(@RequestParam(name="username") String username,
                               @RequestParam(name="email") String email,
                              @RequestParam(name="password") String password,
                              @RequestParam(name="firstname") String firstname,
                              @RequestParam(name="middleName") String middlename,
                              @RequestParam(name="lastName") String lastName,
                              @RequestParam(name="mobile") long mobilenumber,
                              @RequestParam(name="status") String status,
                              @RequestParam(name="profile") String profile,
                              @RequestParam(name="imgPath") String imgPath,
                              @RequestParam(name="originalavatar") String originalavatar


    ){



        user n = new user();
        user firstFriend = usersDao.getById(7l);
        friendslist i = new friendslist();
        i.setAdded_user_id(firstFriend);
        friendslistrepoDao.save(i);
        String hash = passwordEncoder.encode(password);
//        4. lets set all our requested Parameters
        n.setPassword(hash);
        n.setUsername(username);
        n.setEmail(email);
        n.setFirstName(firstname);
        n.setMiddleName(middlename);
        n.setLastName(lastName);
        n.setMobile(mobilenumber);
        n.setStatus(status);
        n.setProfile(profile);


        System.out.println(originalavatar + " IS THIS WORKING?");
        System.out.println(imgPath);
        if (imgPath == ""){
            imgPath = originalavatar;

            System.out.println(imgPath + " ###");
//            originalavatar = imgPath;
        }

//        4. lets set all our requested Parameters
        n.setImgPath(imgPath);
        n.setOriginalavatar(originalavatar);

        usersDao.save(n);
        return "redirect:/home";
    }


    // Create a Users Post

    @GetMapping("/post")
    public String usersPost(Model model)
    {
        model.addAttribute("usersPost", new usersPost());
        model.addAttribute("fileStackApi",fileStackApi);
        return"UserPostingForm";
    }

    @PostMapping("/post")
    public String addAnewUserPost(@RequestParam(name="title") String title,
                                  @RequestParam(name="body") String description,
                                  @RequestParam(name="imgPath") String imgPath
//                                  @RequestParam(name="postOwner") user postOwner


    ){
//        1. lets get the current user
        user user = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        2. get the currentUsers username
        user groupOwnersUsersName = usersDao.getByUsername(user.username);
//        3. lets create a new userspost
        usersPost n = new usersPost();
//        4. lets set all our requested Parameters
        n.setImgPath(imgPath);
        n.setOwner(user);
        n.setTitle(title);
        n.setBody(description);
        usersPost.save(n);
        return "redirect:/home";
    }

    // Create a Group

    @GetMapping("/groupcreation")
    public String createAgroup(Model model)
    {
        model.addAttribute("fileStackApi", fileStackApi);
        return"CreateAGroup";
    }


    @PostMapping("/groupcreation")
    public String addAnewGroup(@RequestParam(name="GroupPosttitle") String title,
                               @RequestParam(name="GroupPostsummary") String summary,
                               @RequestParam(name="GroupPostcreatedBy") String createdBy,
                               @RequestParam(name="GroupPostcontent") String content,
                               @RequestParam(name="GroupPostIMGPath") String GroupPostIMGPath


    ){


        user user = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        groups n = new groups();
        n.setSummary(summary);
        n.setTitle(title);
        n.setContent(content);
        n.setCreatedBy(createdBy);
        n.setGroupOwner(user);
//        save the groups info
        groupDao.save(n);
        return "redirect:/home";
    }


    // Create a Group Post

    @GetMapping("/PostToAGroup")
    public String postToAGroup(Model model)
    {
        model.addAttribute("fileStackApi",fileStackApi);
        model.addAttribute("groupId", groupDao.findAll());  // When I come back to this we can link all groupsThatBelongToOwner
        return"GroupPostingForm";
    }

    @PostMapping("/PostToAGroup")
    public String addAnewGroupPost(@RequestParam(name="GroupPosttitle") String title,
                                   @RequestParam(name="GroupPostsummary") String summary,
                                   @RequestParam(name="GroupPostcreatedBy") String createdBy,
                                   @RequestParam(name="GroupPostcontent") String content,
                                   @RequestParam(name="GroupPostIMGPath") String GroupPostIMGPath

    ){
//        create a new group post
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
