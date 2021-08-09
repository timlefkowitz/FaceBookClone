package com.home.facebookclone.repos;


import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface friendslistrepo extends JpaRepository<friendslist, Long> {

    List<friendslist> getByOwnerUser(user OwnerUser);


}
