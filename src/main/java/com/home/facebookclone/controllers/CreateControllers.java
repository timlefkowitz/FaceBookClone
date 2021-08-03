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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateControllers {

    private final UsersRepository usersDao;

    private final UsersPostRepo usersPost;

    private final groupRepo groupDao;

    private final groupPostRepo groupPostDao;

    private final PasswordEncoder passwordEncoder;


//    private final groupPost groupPostDao;


    public CreateControllers(UsersRepository usersDao, UsersPostRepo usersPost, groupRepo groupDao, groupPostRepo groupPostDao, PasswordEncoder passwordEncoder) {

        this.usersDao = usersDao;
        this.usersPost = usersPost;
        this.groupDao = groupDao;


//        this.groupPostDao = groupPostDao;
        this.groupPostDao = groupPostDao;


//        this.passwordEncoder = passwordEncoder;
        this.passwordEncoder = passwordEncoder;
    }




//    Wiring in FileStack
    @Value("${filestack.api.key}")
    private String fileStackApi;




    // User Sign Up

    @GetMapping("users/sign-up.html")
    public String Signup(Model model)
    {
        model.addAttribute("user", new user());
        model.addAttribute("fileStackApi", fileStackApi);
        return"users/sign-up";
    }

    @PostMapping("users/sign-up.html")
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
        String hash = passwordEncoder.encode(password);
        n.setPassword(hash);
        n.setUsername(username);
        n.setEmail(email);
        n.setFirstName(firstname);
        n.setMiddleName(middlename);
        n.setLastName(lastName);
        n.setMobile(mobilenumber);
        n.setStatus(status);
        n.setProfile(profile);
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


    ){

        user user = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        usersPost n = new usersPost();
        n.setImgPath(imgPath);
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
//        n.setOwner(user);
        n.setSummary(summary);
        n.setTitle(title);
        n.setContent(content);
        n.setCreatedBy(createdBy);
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
        groupPost n = new groupPost();
        n.setTitle(title);
        n.setBody(summary);
        n.setImgPath(GroupPostIMGPath);
        groupPostDao.save(n);
//        groupPost n = new groupPost();
//        groupPostDao.save(n);
        return "redirect:/home";
    }






// Add a Friend

    // Add a Frined

    @GetMapping("/add")
    public String getaddfriend(Model model)
    {
        model.addAttribute("user", new user());
        model.addAttribute("fileStackApi", fileStackApi);
        return"addfriend";
    }

    @PostMapping("/add")
    public String postaddfriend(@RequestParam(name="username") String username


    ){

        user n = new user();
        n.setUsername(username);
        usersDao.save(n);
        return "redirect:/addfriend";
    }



}
