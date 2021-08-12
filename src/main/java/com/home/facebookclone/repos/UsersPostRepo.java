package com.home.facebookclone.repos;


import com.home.facebookclone.models.user;
import com.home.facebookclone.models.usersPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersPostRepo extends JpaRepository<usersPost, Long> {

    usersPost getById(long id);
//    usersPost getusersPostBy(usersPost owner);

//    usersPost findByOwner(user Owner);

//    String findAllByUsername(String username);
//    usersPost getByUsername(String username);


//    usersPost findByOwner(user Owner);
}
