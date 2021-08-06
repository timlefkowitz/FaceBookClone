package com.home.facebookclone.controllers;


import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.friendslistrepo;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;
    private final friendslistrepo friendslistDao;


    public ProfileController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo, friendslistrepo friendslistDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
        this.friendslistDao = friendslistDao;
    }


//    @Autowired
//    private user username;

//    @PostMapping("/{username}")
//    public String showByUsername(@PathVariable Model view, user username, Principal principal)
//    {
//        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//
////        view.addAttribute("username", userDao.getByUsername(username));
////        view.addAttribute("usersFriends", friendslistDao.findContactsByOwner_userId(user));
////        view.addAttribute("usersGroups", userDao.getByUsername(user));
//
//
//
//        return "UsersProfile";
//    }

//    @GetMapping("/{username}")
//    public String getByUsername(@PathVariable String username,
//                                @PathVariable long id,
//                                Model view,
//                                Principal principal
//    )
//    {
//        //current user
//        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<friendslist> friendslist = friendslistDao.findContactsByOwner_userId(currentUser.getId());
//        boolean friendsAlready = !friendslistDao.findByOwner_userAndAdded_user_idExists(id, currentUser.getId()).isEmpty();
//
////        view.addAttribute("friendsList", friendslist);
//        view.addAttribute("user", userDao.getById(id));
//        view.addAttribute("usersProfile", userDao.getByUsername(username));
//
////        return "UsersProfile";
//    }

    @GetMapping("/{username}/{id}")
    public String showById2(@PathVariable Long id, Model view, String username){
        view.addAttribute("user", userDao.getById(id));
        view.addAttribute("username", userDao.getByUsername(username));
        view.addAttribute("usersPost", postsRepo.getById(id));
        view.addAttribute("{id}+friends", userDao.getById(id));
        return "UsersProfile";
    }

    @GetMapping("/{username}")
    public String showByUsername(@PathVariable String username,
                                 Model view
//                                 @RequestParam(name="addfriend") long addID
    ){
        view.addAttribute("user", userDao.getByUsername(username));
//        view.addAttribute("addfriend", addID);
        return "UsersProfile";
    }

    @PostMapping("/{username}")
    public String profilePostings(@RequestParam(name="FriendHidden") long addID){
        friendslist addedFriend = new friendslist();
        user addedUser = userDao.getById(addID);
        user friendslistOwner = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


//        String usernameString = {username};

        addedFriend.setOwner_user(friendslistOwner);
        addedFriend.setAdded_user_id(addedUser);
        friendslistDao.save(addedFriend);


        return "redirect:/";
    }








    @RequestMapping(value="/myprofile")
    public String myprofile(@PathVariable Long id, Model view, String username, String status, Principal principal){
        view.addAttribute("myprofile", userDao.getById(id));
        view.addAttribute("mygroups", groupDao.getById(id));
        view.addAttribute("username", userDao.getByUsername(username));
        view.addAttribute("usersPost", postsRepo.getById(id));
        view.addAttribute("{id}+friends", userDao.getById(id));
        view.addAttribute("myfriends", friendslistDao.getById(id));

        String n = principal.getName();
        view.addAttribute("myprofile", userDao.findByUsername(n));




        return "myprofile";
    }

    @GetMapping("/show/{id}")
    public String showById(@PathVariable long id,Model view){
        view.addAttribute("singlePost", postsRepo.getById(id));
        return"singlePost";
    }




//    @PostMapping("show/{id}/delete")
//    public String deleteUsersPost(@PathVariable Long id)
//    {
//        Order order = orderDao.getById(id);
//        orderDao.delete(order);
//        return "redirect:/show";
//    }





}
