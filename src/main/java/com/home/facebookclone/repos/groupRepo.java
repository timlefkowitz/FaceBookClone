package com.home.facebookclone.repos;


import com.home.facebookclone.models.friendslist;
import com.home.facebookclone.models.groups;
import com.home.facebookclone.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface groupRepo extends JpaRepository<groups, Long> {

//    groups findByGroupName(String title);

    groups getByTitle(String title);
//    List<groups> getByGroupUser(user OwnerUser);
//    groups getByGroupOwner(String groupOwner);
//
//    Collection<groups> getByGroupMember(String groupMember);
}
