package com.home.facebookclone.controllers;


import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.friendslistrepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
public class friendsController {



//  I'm not sure if i want filestack here or not


    //    Wiring in FileStack   ///
//    @Value("${filestack.api.key}")
//    private String fileStackApi;




    //     Daos

    private UsersRepository users;
    private PasswordEncoder passwordEncoder;
    private friendslistrepo friends;



    //      Constructors

    public friendsController(UsersRepository users, PasswordEncoder passwordEncoder, friendslistrepo friends) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.friends = friends;
    }


    //      GetMapping and Post Mapping


    @PostMapping("/friends")
//    @ResponseBody
    public String friendspage(@RequestParam(name = "addedUser") String addedUser)
    {


        user userInSession = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user currentUser = users.getById(userInSession.getId());
        user addthisUser = users.getByUsername(addedUser);
//        friendslist n = new friendslist();

//        userInSession.getContactListOwner();
        Collection<friendslist> currentUsersFriends = currentUser.getContactListOwner();
        currentUsersFriends.add(new friendslist(currentUser, addthisUser));
//        n.setOwner_user(userInSession);
//        n.setAdded_user_id(addthisUser);
        currentUser.setContactListOwner(currentUsersFriends);
        users.save(currentUser);
//        friends.save(n);


        Collection<friendslist> addFriend = userInSession.getContactListOwner();
//        user addthisUserID = users.getById(addID);
//
//        addFriend.setOwner_user(friendslistOwner);
//        addFriend.setAdded_user_id(addthisUserID);
//        friends.save(addFriend);


//        return"redirect:/friends";
        return "redirect:/friends";
    }

    @GetMapping("/friends")
    public String getFriends(Model view)
    {

        user FRIENDSLISTOWNER = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        long currentUser = FRIENDSLISTOWNER.getId();
        List<friendslist> friendslistGen = friends.getByOwnerUser(FRIENDSLISTOWNER);



        System.out.println(friendslistGen.size());
//        view.addAttribute("allusers", friends.findAll());
        view.addAttribute("friendslistHidden", friendslistGen);
//        view.addAttribute("friendslistGen", friendslistGen);




        return "friends";
    }

    // Add a Friend

    // Add a Frined

//    @GetMapping("/add")
//    public String getaddfriend(Model model)
//    {
//        model.addAttribute("user", new user());
//        return"addfriend";
//    }
//
//    @PostMapping("/add")
//    public String postaddfriend(@RequestParam(name="username") String username
//
//
//    ){
//
//        user n = new user();
//        n.setUsername(username);
//        usersDao.save(n);
//        return "redirect:/addfriend";
//    }


}
