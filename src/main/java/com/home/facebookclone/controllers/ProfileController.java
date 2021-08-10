package com.home.facebookclone.controllers;


import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import com.home.facebookclone.repos.UsersPostRepo;
import com.home.facebookclone.repos.UsersRepository;
import com.home.facebookclone.repos.friendslistrepo;
import com.home.facebookclone.repos.groupRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@Controller
public class ProfileController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;
    private final friendslistrepo friendslistDao;



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

        //adding featured post. Lets make featuredPost.length, then random number between the length of all post.
        // then use math random to select one of the post

//        long featuredPost = (long) ( Math.random() * 2 + 1);


//        lets grab the friendslist by username

//        1. convert user to the username
        user friendslistOwner = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        2. lets generate the current friendslist
        Collection<friendslist> friendslistGen = friendslistDao.getByOwnerUser(friendslistOwner);


//        0.001 add Attributes
        view.addAttribute("user", userDao.getByUsername(username));
        view.addAttribute("FriendsListRepo", friendslistGen);




//        view.addAttribute("featuredPost", postsRepo.findAllByUsername(username));


//        user featuredPostOwner = userDao.getByUsername(username);
//        view.addAttribute("theFeaturedPost", postsRepo.findByOwner(featuredPostOwner));
//        view.addAttribute("addfriend", addID);
        return "UsersProfile";
    }

    @PostMapping("/{username}")
    public String profilePostings(@RequestParam(name="FriendHidden") long addID){

//        Creating a new friends list query
//        1. we are creating a new friendslist
        friendslist addedFriend = new friendslist();

//        2. creating the variable to add by users ID
        user addedUser = userDao.getById(addID);

//        3. this tells us who the current user is
        user friendslistOwner = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        long newfriend = addedUser.getId();

//        String usernameString = {username};

        addedFriend.setOwner_user(friendslistOwner);
        addedFriend.setAdded_user_id(addedUser);
        friendslistDao.save(addedFriend);


        return "redirect:/home";
    }




//    @RequestMapping(value="/myprofile")
//    public String myprofile(@PathVariable Long id, Model view, String username, String status, Principal principal){
//        view.addAttribute("myprofile", userDao.getById(id));
//        view.addAttribute("mygroups", groupDao.getById(id));
//        view.addAttribute("username", userDao.getByUsername(username));
//        view.addAttribute("usersPost", postsRepo.getById(id));
//        view.addAttribute("{id}+friends", userDao.getById(id));
//        view.addAttribute("myfriends", friendslistDao.getById(id));
//
//        String n = principal.getName();
//        view.addAttribute("myprofile", userDao.findByUsername(n));
//
//
//
//
//        return "myprofile";
//    }

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


    public ProfileController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo, friendslistrepo friendslistDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
        this.friendslistDao = friendslistDao;
    }



}
