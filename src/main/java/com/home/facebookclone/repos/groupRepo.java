package com.home.facebookclone.repos;


import com.home.facebookclone.models.groups;
import com.home.facebookclone.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupRepo extends JpaRepository<groups, Long> {

//    groups findByGroupName(String title);

    groups getByTitle(String title);
}
