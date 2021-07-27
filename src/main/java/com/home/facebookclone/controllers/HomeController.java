package com.home.facebookclone.controllers;


import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    // I need to throw some catch statements into this capstone
//           if(HomeController = null ){
//        throw new IllegalArgumentException();
//    }


    // Repo Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;

    public HomeController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
    }




//    @GetMapping("/admin")
//    public String adminHome(Model view)
//    {
//        view.addAttribute("allusers", userDao.findAll());
//        view.addAttribute("allgroups", groupDao.findAll());
//        view.addAttribute("allposts", postsRepo.findAll());
//        return"admin/AdminsHome";
//    }

//
//
//    @GetMapping("/signup")
//    public String signup()
//    {
//        return"signup";
//    }
//




    // HOME PAGE

//    @GetMapping("/UsersHome")
//    public String usersHome()
//    {
//        return"UsersHome";
//    }
//
//    @GetMapping("/UsersHome/{id}")
//    public String showById(@PathVariable Long id, Model view){
//        view.addAttribute("user", userDao.getById(id));
//        view.addAttribute("allusers", userDao.findAll());
//        view.addAttribute("allgroups", groupDao.findAll());
//        view.addAttribute("allposts", postsRepo.findAll());
//        return "UsersHome";
//    }

//
//    @GetMapping("/UsersProfile")
//    public String usersProfile()
//    {
//        return"UsersProfile";
//    }
//
//    // Currently Signed in profile
//    @GetMapping("/currentProfile")
//    public String currentUsersProfile()
//    {
//        return"CurrentUsersProfileAndEditProfile";
//    }


    @GetMapping("/")
    public String adminHome(Model view)
    {
        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allposts", postsRepo.findAll());
        return"home";
    }

    @GetMapping("/friends")
    public String friendspage(Model view)
    {
        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allposts", postsRepo.findAll());
        return"friends";
    }

    @GetMapping("/groups")
    public String groupspage(Model view)
    {
        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allposts", postsRepo.findAll());
        return"groups";
    }


    //    Wiring in FileStack
    @Value("${filestack.api.key}")
    private String fileStackApi;


    // Show Constructors

    @GetMapping("/UsersProfile")
    public String show(Model view){
        view.addAttribute("user", userDao.findAll());
        return"UsersProfile";
    }

    @GetMapping("/UsersProfile/{id}")
    public String showById(@PathVariable Long id, Model view){
        view.addAttribute("user", userDao.getById(id));
        view.addAttribute("usersPost", postsRepo.getById(id));
        return "UsersProfile";
    }

    @GetMapping("/{username}/{id}")
    public String showById2(@PathVariable Long id, Model view, String username, String status){
        view.addAttribute("user", userDao.getById(id));
        view.addAttribute("username", userDao.getByUsername(username));
        view.addAttribute("usersPost", postsRepo.getById(id));
        view.addAttribute("{id}+friends", userDao.getById(id));
        return "UsersProfile" + status;
    }







}
