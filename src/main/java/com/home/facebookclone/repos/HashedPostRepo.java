package com.home.facebookclone.repos;

import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface HashedPostRepo extends JpaRepository<friendslist, Long> {



    Collection<HashedPostRepo> getByOwnerUsername(user ownerUsername);


}
