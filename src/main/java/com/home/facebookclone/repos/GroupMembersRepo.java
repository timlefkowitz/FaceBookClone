package com.home.facebookclone.repos;


import com.home.facebookclone.models.groupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMembersRepo extends JpaRepository<groupMember, Long> {
//    List<groupMember> getByGroupUser(groupMember OwnerUser);

}
