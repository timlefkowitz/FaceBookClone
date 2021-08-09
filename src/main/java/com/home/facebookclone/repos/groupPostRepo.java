package com.home.facebookclone.repos;


import com.home.facebookclone.models.groupPost;
import com.home.facebookclone.models.groups;
import com.home.facebookclone.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupPostRepo extends JpaRepository<groupPost, Long> {


//    coming back to this in the future
//    user findByUsername(String userName);
//    user getByUsername(String username);
//    groups findByGroupName(String title);
}
