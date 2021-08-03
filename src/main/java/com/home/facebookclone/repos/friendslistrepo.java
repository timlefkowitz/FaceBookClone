package com.home.facebookclone.repos;


import com.home.facebookclone.models.friendslist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface friendslistrepo extends JpaRepository<friendslist, Long> {

    @Query(value = "SELECT * FROM  FBclone.friendslist WHERE list_owner_id = ?1",  nativeQuery = true)
    List<friendslist> findContactsByOwner_userIs(long id);

    @Query(value = "SELECT * FROM FBclone.friendslist WHERE added_user_id = ?1 AND list_owner_id = ?2", nativeQuery = true)
    List<friendslist> findByOwner_userAndAdded_user_idExists(long added_user_id, long list_owner_id);
}
