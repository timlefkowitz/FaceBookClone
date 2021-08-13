package com.home.facebookclone.repos;


import com.home.facebookclone.models.status;
import com.home.facebookclone.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface statusRepo extends JpaRepository<status, String> {

//
//    user getByUsername(user username);
}
