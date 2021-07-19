package com.home.facebookclone.controllers;


import com.home.facebookclone.models.groupPost;
import com.home.facebookclone.models.groups;
import com.home.facebookclone.models.user;
import com.home.facebookclone.models.usersPost;
import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;

import com.home.facebookclone.repos.groupPostRepo;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateControllers {

    private final UsersRepository userDao;

    private final UsersRepository usersDao;

    private final UsersPostRepo usersPost;

    private final groupRepo groupDao;

    private final groupPostRepo groupPostDao;

//    private final groupPost groupPostDao;


    public CreateControllers(UsersRepository userDao, UsersRepository usersDao, UsersPostRepo usersPost, groupRepo groupDao, groupPostRepo groupPostDao) {
        this.userDao = userDao;
        this.usersDao = usersDao;
        this.usersPost = usersPost;
        this.groupDao = groupDao;
//        this.groupPostDao = groupPostDao;
        this.groupPostDao = groupPostDao;
    }




//    Wiring in FileStack
    @Value("${filestack.api.key}")
    private String fileStackApi;




    // User Sign Up

    @GetMapping("/signup.html")
    public String Signup(Model model)
    {
        model.addAttribute("fileStackApi", fileStackApi);
        return"signup";
    }

    @PostMapping("/signup.html")
    public String addANewUser(@RequestParam(name="inputUserName") String username,
                               @RequestParam(name="inputEmail") String email,
                              @RequestParam(name="inputPassword") String password,
                              @RequestParam(name="inputFirstName") String firstname,
                              @RequestParam(name="inputMiddleName") String middlename,
                              @RequestParam(name="inputLastName") String lastname,
                              @RequestParam(name="inputMobile") long mobilenumber,
                              @RequestParam(name="status") String status,
                              @RequestParam(name="profile") String profile,
                              @RequestParam(name="imgPath") String imgPath

    ){

        user n = new user();
        n.setUserName(username);
        n.setEmail(email);
        n.setPasswordHash(password);
        n.setFirstName(firstname);
        n.setMiddleName(middlename);
        n.setLastName(lastname);
        n.setMobile(mobilenumber);
        n.setStatus(status);
        n.setProfile(profile);
        n.setImgPath(imgPath);
        usersDao.save(n);
        return "redirect:/UsersHome";
    }

    // Create a Group

    @GetMapping("/groupcreation")
    public String createAgroup(Model model)
    {
        model.addAttribute("fileStackApi", fileStackApi);
        return"CreateAGroup";
    }


    @PostMapping("/groupcreation")
    public String addAnewGroup(@RequestParam(name="inputTitle") String title,
                               @RequestParam(name="inputDescription") String description

    ){

        groups n = new groups();
        n.setTitle(title);
        n.setContent(description);
        groupDao.save(n);
        return "redirect:/UsersHome";
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
    public String addAnewGroupPost(@RequestParam(name="title") String title,
                                   @RequestParam(name="body") String body,
                                   @RequestParam(name="imgPath") String imgPath

    ){
        groupPost n = new groupPost();
        n.setTitle(title);
        n.setBody(body);
        n.setImgPath(imgPath);
        groupPostDao.save(n);
//        groupPost n = new groupPost();
//        groupPostDao.save(n);
        return "redirect:/UsersHome";
    }


    // Create a Users Post

    @GetMapping("/post")
    public String usersPost(Model model)
    {
        model.addAttribute("fileStackApi",fileStackApi);
        return"UserPostingForm";
    }

    @PostMapping("/post")
    public String addAnewUserPost(@RequestParam(name="inputTitle") String title,
                              @RequestParam(name="inputDescription") String description,
                                   @RequestParam(name="imgPath") String imgPath


    ){

        usersPost n = new usersPost();
        n.setImgPath(imgPath);
        n.setTitle(title);
        n.setBody(description);
        usersPost.save(n);
        return "redirect:/UsersHome";
    }




    //addfriend

    @GetMapping("/addfriend")
    public String addfriendPage()
    {
        return"UserPostingForm";
    }

    @PostMapping("/addfriend")
    public String addfriend (Model view, @RequestParam(name="usernameToAdd") String username






    ) {
        //Find all users
        view.addAttribute("allusers", usersDao.findAll());

//        addfriend n = new usersPost();
//        n.setTitle(title);
//        n.setBody(description);
//        usersPost.save(n);
//        return "redirect:/UsersHome";

    return "redirect:/UsersHome";
    }




}
