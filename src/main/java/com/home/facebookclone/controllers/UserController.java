package com.home.facebookclone.controllers;

import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.friendslistrepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UsersRepository users;

    private PasswordEncoder passwordEncoder;

    private friendslistrepo friendslistDao;

    public UserController(UsersRepository users, PasswordEncoder passwordEncoder, friendslistrepo friendslistDao) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.friendslistDao = friendslistDao;
    }


    //    Wiring in FileStack
    @Value("${filestack.api.key}")
    private String fileStackApi;





    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new user());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute user user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("addfriend")
    public String addfriend(Model model)
    {
        model.addAttribute("allusers", new friendslist());
        model.addAttribute("fileStackApi", fileStackApi);
        return"users/sign-up";
    }

    @PostMapping("addfriend")
    public String addAusernameToyourFriendsList(@RequestParam(name="username") String username

    ){

        friendslist n = new friendslist();
        n.setUsername(username);
        friendslistDao.save(n);
        return "redirect:/UsersHome";
    }


}
